/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindFrequentTreeSum {
    HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer> ();
    public int findTreeSum(TreeNode root) {
        if(root == null)
            return 0;
        int sum = findTreeSum(root.left) + root.val + findTreeSum(root.right);
        int count = 0;
        if(countMap.containsKey(sum)) {
            count = countMap.get(sum);
        }
        countMap.put(sum, count + 1);
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        findTreeSum(root);
        ArrayList<Integer> frequentList = new ArrayList<Integer>();
        int maxCount = -1;
        for(Integer sum : countMap.keySet()) {            
            int count = countMap.get(sum);
            if(count > maxCount) {
                maxCount = count;
                frequentList = new ArrayList<Integer>();
            }
            if(count == maxCount) {
                frequentList.add(sum);
            }
        }
        int[] result = new int[frequentList.size()];
        int index = 0;
        for(int num : frequentList) {
            result[index++] = num;
        }
        return result;
    }
}
