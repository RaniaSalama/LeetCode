class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> ranges = new ArrayList<String>();
        int n = nums.length;
        while (i < n) {
            int firstNum = nums[i];
            while((i+1 < n) && (nums[i+1]-nums[i] == 1)) {
                i++;
            }
            if(nums[i] == firstNum){
                ranges.add(nums[i]+"");
            } else {
                ranges.add(firstNum+"->"+nums[i]);
            }
            i++;
        }
        return ranges;
    }
}
