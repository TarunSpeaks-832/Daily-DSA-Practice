class Solution {
    public int gcdOfOddEvenSums(int n) {
        int O_Sum = n*n;
        int E_Sum = n*(n+1);

        while(O_Sum != 0){
            int temp = O_Sum;
            O_Sum = E_Sum % O_Sum;
            E_Sum = temp;
        }
        
        return E_Sum;
    }
}