class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int countZeros = 0;
        int allMutliplication = 1;
        for(int i = 0; i < nums.length; i++) {
            allMutliplication *= nums[i];
            if(nums[i] == 0)
                countZeros++;
        }
        if(countZeros >= 2) {
            for(int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
        } else if (countZeros == 1) {
            allMutliplication = 1;
            int zeroIndex = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    zeroIndex = i;
                } else {
                    allMutliplication *= nums[i];
                    nums[i] = 0;
                }
            }
            nums[zeroIndex] = allMutliplication;
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    nums[i] = allMutliplication/nums[i];
                }
            }
        }
        return nums;
    }
}
