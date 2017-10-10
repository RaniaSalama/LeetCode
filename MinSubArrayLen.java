class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int w = 1; w <= n; w++){
            for(int i = 0; i <= n - w; i++) {
                if(sum[i+w] - sum[i]>= s) {
                    return w;
                }
            }
        }
        return 0;
    }
}


