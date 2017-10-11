class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer> ();
        int count = 0;
        counter.put(0, 1);
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(counter.containsKey(sum - k)) {
                count += counter.get(sum - k);
            }
            int countSum = 0;
            if(counter.containsKey(sum)) {
                countSum = counter.get(sum);
            }
            counter.put(sum, countSum+1);
        }
        return count;
    }
}
