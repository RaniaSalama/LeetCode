/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode bottomLeftNode = null;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            bottomLeftNode = node;
            if(node.right != null) {
                queue.add(node.right);
            }
            if(node.left != null) {
                queue.add(node.left);
            }
        }
        return bottomLeftNode.val;
    }
}
