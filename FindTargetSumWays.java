class FindTargetSumWays {
    int[][] dp;
    public int solve(int[] nums, int S, int k) {
        if(S == 0 && k == nums.length){ 
            return 1;
        }
        if(k >= nums.length) {
            return 0;
        }
        int ways = 0;
        if(dp[S-nums[k]+2000][k+1] == -1) { 
            int way = solve(nums, S-nums[k], k+1);
            ways += way;
            dp[S-nums[k]+2000][k+1] = way;
        } else {
            ways += dp[S-nums[k]+2000][k+1];
        }
        if(dp[S+nums[k]+1001][k+1] == -1) {
            int way = solve(nums, S+nums[k], k+1);
            ways += way;
            dp[S+nums[k]+1001][k+1] = way;
        } else {
            ways += dp[S+nums[k]+1001][k+1];
        }
        return ways;
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if(S > sum || S < -1*sum)
            return 0;
        dp = new int[S+4001][nums.length+1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
 
        return solve(nums, S, 0);
    }
}
