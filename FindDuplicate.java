class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int n =  nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[Math.abs(nums[i])-1] < 0) { // duplicate
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i])-1] = -1 * nums[Math.abs(nums[i])-1];
            }
        }
        return -1;
    }
}
