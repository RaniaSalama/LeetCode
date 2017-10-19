class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] nums1Copy = new int[m];
        for(int i = 0; i < m; i++) 
            nums1Copy[i] = nums1[i];
        int index = 0;
        while(p1 < m && p2 < n) {
            if(nums1Copy[p1] <= nums2[p2]) {
                nums1[index++] = nums1Copy[p1++];
            } else {
                nums1[index++] = nums2[p2++];
            }
        }
        
        while(p1 < m) {
            nums1[index++] = nums1Copy[p1++];
        }
        
        while(p2 < n) {
            nums1[index++] = nums2[p2++];
        }
    }
}
