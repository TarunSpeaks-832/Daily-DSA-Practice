class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i=0,j=0;
        int cnt = 0;
        if(n == 0 || m == 0) return cnt;
        while(i < n && j < m){
            if(s[j] >= g[i]){
                cnt++;
                i++;
                j++;
            }
            else if(s[j] < g[i]) j++;
        }
        return cnt;
    }
}