class Twitter {
    public static int timeStamp = 0;

    HashMap<Integer , User> userMap;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timeStamp++;
            next = null;
        } 
    }

    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<Integer , User>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId,u);
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new LinkedList<>();

		if(!userMap.containsKey(userId))   return feed;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a,b)->(b.time-a.time));

        for(int user : users){
            Tweet t = userMap.get(user).tweet_head;
            if(t != null) pq.add(t);
        }

        int n = 0;
        while(!pq.isEmpty() && n<10){
            Tweet t_head = pq.poll();
            feed.add(t_head.id);
            n++;
            if(t_head.next != null){
                pq.add(t_head.next);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */