class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length;
        int m = trainers.length;
        int i=0,j=0;
        int cnt = 0;
        if(n == 0 || m == 0) return cnt;
        while(i < n && j < m){
            if(players[i] <= trainers[j]){
                cnt++;
                i++;
                j++;
            }
            else j++;
        }
        return cnt;
    }
}