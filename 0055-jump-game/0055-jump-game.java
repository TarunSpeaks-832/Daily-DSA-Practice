class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int tg = 1;
        if(n == 1) return true;
        for(int i=n-2;i>=0;i--){
            if(nums[i] >= tg){
                tg = 1;
            }
            else tg++;
        }
        if(tg == 1) return true;
        return false;
    }
}