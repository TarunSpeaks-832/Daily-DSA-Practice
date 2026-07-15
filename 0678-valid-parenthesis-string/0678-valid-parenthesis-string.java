class Solution {
    public boolean checkValidString(String s) {
        int l_min = 0;
        int l_max = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                l_min++;
                l_max++;
            } 
            else if(c == ')'){
                l_min--;
                l_max--;
            } 
            else{
                l_min--;
                l_max++;
            }

            if(l_max < 0) return false;
            if(l_min < 0) l_min = 0;
        }
        return l_min == 0;
    }
}