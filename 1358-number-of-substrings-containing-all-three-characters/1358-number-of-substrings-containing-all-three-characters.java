class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0;
        int cnt = 0;
        for(int r=0;r<n;r++){
            char c = s.charAt(r);
            map.put(c , map.getOrDefault(c , 0) + 1);
            while(map.size() >= 3){
                cnt += n-r;
                map.put(s.charAt(l) , map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
        }
        return cnt;
    }
}