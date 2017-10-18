/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CountNodes {
    public int countNodesSolution1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.left != null) {
            count += countNodes(root.left);
        } 
        if(root.right != null){
            count += countNodes(root.right);
        }
        return count + 1;
    }
    
     public int getHeight(TreeNode root) {
         if(root == null)
             return 0;
         return 1 + getHeight(root.left);
     }
    
     public int countNodes(TreeNode root) {
         if(root == null){
            return 0;
         } else {
            int h = getHeight(root);
            int hRight = getHeight(root.right);
            if(hRight == h-1) { // left and right subtrees have the same height.
                return (1 << hRight) + countNodes(root.right);
            } else {
                return (1 << hRight) + countNodes(root.left);
            }
         }
    }
    
}
