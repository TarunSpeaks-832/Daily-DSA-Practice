class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int cnt = 0;
        int n = s.length();
        int l = 0;
        String ans = "";
        for(int r=0;r<n;r++){
            if(s.charAt(r) == '1'){
                cnt++;
            }
            
            while(cnt > k){
                if(s.charAt(l) == '1') cnt--;
                l++;
            }

            if(cnt == k){
                while (l < r && s.charAt(l) == '0') {
                    l++;
                }

                String cur = s.substring(l , r+1);

                if(ans.isEmpty() || 
                    cur.length() < ans.length() || 
                        (cur.length() == ans.length() && cur.compareTo(ans) < 0)){
                    ans = cur;
                }
            }
        }
        return ans;
    }
}