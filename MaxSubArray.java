class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int prevSum = 0;
        for(int i = 1; i <= n; i++) {
            prevSum = Math.max(nums[i-1], prevSum+nums[i-1]);
            maxSum = Integer.max(maxSum, prevSum);
        }
        return maxSum;
    }
}
