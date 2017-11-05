/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Flatten {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode currNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root.right != null)
            stack.push(root.right);
        if(root.left != null)
            stack.push(root.left);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
            currNode.right = node;
            currNode.left = null; 
            currNode = node;
        }
    }
}




    
    
