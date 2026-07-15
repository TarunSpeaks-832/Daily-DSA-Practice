class Solution {
    public int gcdOfOddEvenSums(int n) {
        int E_Sum = 0;
        int O_Sum = 0;
        int m = 2*n+1;
        for(int i=1;i<m;i++){
            if ((i & 1) == 0)
                E_Sum += i;
            else
                O_Sum += i;
        }
        while(O_Sum != 0){
            int temp = O_Sum;
            O_Sum = E_Sum % O_Sum;
            E_Sum = temp;
        }
        return E_Sum;
    }
}