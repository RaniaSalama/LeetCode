/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxs = new ArrayList<Integer>();
        if(root == null) {
            return maxs;
        }
        Queue<HashMap<TreeNode, Integer>> queue = new LinkedList<HashMap<TreeNode, Integer>> ();
        HashMap<TreeNode, Integer> rootMap = new HashMap<TreeNode, Integer>();
        rootMap.put(root, 0);
        queue.add(rootMap);
        while(!queue.isEmpty()) {
            HashMap<TreeNode, Integer> entry = queue.poll();
            TreeNode node = null;
            int level = 0;
            for(TreeNode tmpNode: entry.keySet()) {
                node = tmpNode;
                level = entry.get(node);
            }
            if(maxs.size() <= level) {
                maxs.add(node.val);
            } else {
                int currentMax = maxs.get(level);
                maxs.set(level, Math.max(currentMax, node.val));
            }
            if(node.left != null) {
                HashMap<TreeNode, Integer> leftMap = new HashMap<TreeNode, Integer>();
                leftMap.put(node.left, level+1);
                queue.add(leftMap);
            } 
            if(node.right != null) {
                HashMap<TreeNode, Integer> rightMap = new HashMap<TreeNode, Integer>();
                rightMap.put(node.right, level+1);
                queue.add(rightMap);
            }
        }
        return maxs;
    }
}
