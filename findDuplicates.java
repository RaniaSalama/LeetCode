class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<Integer>();
        int n = nums.length;
        int[] duplicateCount = new int[n];
        for(int i = 0; i < n; i++) {
            duplicateCount[nums[i]-1]++;
            if(duplicateCount[nums[i]-1] == 2) {
                duplicateNumbers.add(nums[i]);   
            }
        }
        return duplicateNumbers;
    }
}
