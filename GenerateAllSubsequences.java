class GenerateAllSubsequences {
    public ArrayList<Integer> add(ArrayList<Integer> selectedNums, int j){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        newList.addAll(selectedNums);
        newList.add(j);
        return newList;
    }
     public String getString(ArrayList<Integer> selectedNums, int j){
        StringBuilder str = new StringBuilder("");
        for(int num : selectedNums) {
            str.append(num);
            str.append(",");
        }
         str.append(j);
         return str.toString();
    }
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    HashSet<String> set = new HashSet<String>();
    public void generateAllSubsequences(int[] nums, int i, ArrayList<Integer> selectedNums) {
        if(i == nums.length) {
            return;
        }
        for(int j = i; j < nums.length; j++) {
            if(selectedNums.size() == 0) {
                selectedNums.add(nums[j]);
                generateAllSubsequences(nums, j+1, selectedNums);
                selectedNums.remove(Integer.valueOf(nums[j]));
            }
            else if(selectedNums.get(selectedNums.size() - 1) <= nums[j]) { // include.
                String resultStr = getString(selectedNums, nums[j]);
                if(!set.contains(resultStr)) {
                    result.add(add(selectedNums, nums[j]));
                    selectedNums.add(nums[j]);
                    generateAllSubsequences(nums, j+1, selectedNums);
                    selectedNums.remove(Integer.valueOf(nums[j]));
                    set.add(resultStr);
                }
            }
            // don't include.
            generateAllSubsequences(nums, j+1, selectedNums);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        generateAllSubsequences(nums, 0, new ArrayList<Integer> ());
        return result;
    }
}

    
    
