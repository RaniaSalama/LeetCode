class Makesquare {
    
    public boolean dfs(int[] nums, int i, int[] sum, int limit) {
        if(i == nums.length) {
            int squareLength = sum[0];
            for(int s = 1; s < sum.length; s++) {
                if(sum[s] != squareLength) 
                    return false;
            }
            return true;
        } else {
            boolean can = false;
            for(int j = 0; j < 4; j++) {
                if(sum[j]+nums[i] > limit) {
                    continue;
                }
                sum[j] += nums[i];
                can = can || dfs(nums, i+1, sum, limit);
                sum[j] -= nums[i];
            }
            return can;
        }
    }
    
    public boolean makesquare(int[] nums) {
        if(nums.length == 0) {
            return false;
        } else {
            int limit = 0;
            for(int i = 0; i < nums.length; i++) {
                limit += nums[i];
            }
            if(limit % 4 != 0)
                return false;
            limit = (int) Math.floor(limit / 4.0);
            return dfs(nums, 0, new int[4], limit);
        }
    }
}
