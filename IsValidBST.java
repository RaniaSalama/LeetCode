/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class IsValidBST {
    public boolean isValid(TreeNode root, double max, double min) {
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValid(root.left, Math.min(root.val, max), min)
            && isValid(root.right, max, Math.max(root.val, min));
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Double.MAX_VALUE, -1 *  Double.MAX_VALUE);
    }
}
        
