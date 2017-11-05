/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        Queue<State> queue = new LinkedList<State> ();
        queue.add(new State(root, 0));
        List<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            State state = queue.poll();
            TreeNode node = state.node;
            int level = state.level;
            if(result.size() <= level) {
                result.add(node.val);
            } else {
                result.set(level, node.val);
            }
            if(node.left != null)
                queue.add(new State(node.left, level+1));
            if(node.right != null)
                queue.add(new State(node.right, level+1));
        }
        return result;
    }
}

class State {
    TreeNode node;
    int level;
    public State(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
