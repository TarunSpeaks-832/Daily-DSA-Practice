class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] > nums[max1]) max1 = i;
        }
        int x = nums[max1];
        nums[max1] = 0;
        for(int i=0;i<n;i++){
            if(nums[i] > nums[max2]) max2 = i;
        }
        int y = nums[max2];
        return (x - 1) * (y - 1);
    }
}