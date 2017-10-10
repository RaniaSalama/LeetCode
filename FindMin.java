class FindMin {
    public int findMin(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i+1 < n && nums[i+1] > nums[i]) {
            i++;
        }
        if(i+1 < n)
            return Math.min(nums[i+1], nums[0]);
        else
            return nums[0];
    }
}
