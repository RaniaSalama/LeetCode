class Intersection {
    
    public int BS(int start, int end, int element, int[] nums) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == element)
            return mid;
        else if (nums[mid] < element) {
            return BS(mid + 1, end, element, nums);
        } else {
            return BS(start, mid-1, element, nums);
        }
    }
    // Trying binary search for the purpose of trying binary search!
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        HashSet<Integer> intersection = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            if (BS(0, nums2.length-1, nums1[i], nums2) != -1) {
                intersection.add(nums1[i]);
            }
        }
        int[] res = new int[intersection.size()];
        int index = 0;
        for(int num : intersection) {
            res[index++] = num;
        }
        return res;
    }
}
