/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) {
            return null;
        }
        if(d == 1) { // root node.
            TreeNode node1 = new TreeNode(v);
            node1.left = root;
            return node1;
        }
        else if(d == 2) {
            TreeNode node1 = new TreeNode(v);
            node1.left = root.left;
            TreeNode node2 = new TreeNode(v);
            node2.right = root.right;
            root.left = node1;
            root.right = node2;
            return root;
        } else {
            addOneRow(root.left, v, d - 1);
            addOneRow(root.right, v, d - 1);
            return root;
        }
    }
}

           
           
