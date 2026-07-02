class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) return false;
        
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : hand){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty()){
            int firstCard = pq.peek();
            if(map.get(firstCard) == 0){
                pq.poll();
                continue;
            }
            for(int i=0;i<groupSize;i++){
                int curr = firstCard + i;
                if(!map.containsKey(curr) || map.get(curr) == 0){
                    return false;
                }

                map.put(curr , map.get(curr) - 1);
            }
        }
        return true;
    }
}