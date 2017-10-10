class MajorityElement {
    
    public int orderStatistics(ArrayList<Integer> nums, int k) {
      if(nums.size() <= 3) {
          if(k >= nums.size())
              return -1;
          Collections.sort(nums);
          return nums.get(k);
      }
      int n = nums.size();
      Random random = new Random() ; 
      int randomSplit = random.nextInt(n);
      int randomElement = nums.get(randomSplit);
      ArrayList<Integer> S1 = new ArrayList<Integer>();
      ArrayList<Integer> S2 = new ArrayList<Integer>();
      ArrayList<Integer> S3 = new ArrayList<Integer>();
      for(Integer num: nums) {
          if(num < randomElement) {
              S1.add(num);
          } else if(num == randomElement) {
              S2.add(num);
          } else {
              S3.add(num);
          }
      }
      if(k < S1.size()) {
          return orderStatistics(S1, k);
      }  else if (k < S1.size() + S2.size()) {
          return randomElement;
      } else {
          return orderStatistics(S3, k - S1.size() - S2.size());
      }
    }
    
    public int countNumber(int[] nums, int x) {
        int count = 0;
        for(Integer num: nums) {
            if(num == x) {
                count++;
            }   
        }
        return count;
    }
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            numsList.add(nums[i]);
        }
        List<Integer> duplicate = new ArrayList<Integer>();
        int x1 = orderStatistics(numsList, n/3);
        int countx1 = countNumber(nums, x1);
        if(countx1 > n/3) {
            duplicate.add(x1);
        }
        int x2 = orderStatistics(numsList, (2*n)/3);
        int countx2 = countNumber(nums,x2);
        if(countx2 > n/3 && x1 != x2) {
            duplicate.add(x2);
        }
        return duplicate;
    }
}
