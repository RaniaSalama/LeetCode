class SearchInsert {
    public int BS(int start, int end, int target, int[] nums) {
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target ||
           ((mid-1) >= 0 && nums[mid-1] < target
                                && nums[mid] > target)) {
            return mid;
        } else if (nums[mid] > target) {
            return BS(start, mid-1, target, nums);
        } else {
            return BS(mid+1, end, target, nums);
        }
    }
    
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;
        else if(target > nums[nums.length - 1])
            return nums.length;
        else
            return BS(0, nums.length - 1, target, nums);
    }
}
