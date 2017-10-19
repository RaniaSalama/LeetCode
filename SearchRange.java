class SearchRange {
    
    public int BS(int start, int end, int target, int[] nums, boolean isFirst) {
        if(start > end) {
            return -1;
        } else {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                if(isFirst){
                    if(mid == 0 || nums[mid-1] != target)
                        return mid;
                    else
                        return BS(start, mid-1, target, nums, isFirst);
                } else {
                    if (mid == nums.length - 1 || nums[mid+1] != target)
                        return mid;
                    else
                        return BS(mid+1, end, target, nums, isFirst);
                }
            } else if(nums[mid] > target) {
                return BS(start, mid-1, target, nums, isFirst);
            } else {
                return BS(mid+1, end, target, nums, isFirst);
            }
        }
    }
    
    
    
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = BS(0, nums.length-1, target, nums, true);
        range[1] = BS(0, nums.length-1, target, nums, false);
        return range;
    }
}
