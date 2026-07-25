class Solution {
    public int maxProduct(int n) {
        int maxP = 0;
        int maxD = n%10;
        n /= 10;
        while(n > 0){
            int d = n%10;
            n /= 10;
            int P = d*maxD;
            maxP = (maxP <= P)? P : maxP;
            if(d > maxD) maxD = d;
        }
        return maxP;
    }
}