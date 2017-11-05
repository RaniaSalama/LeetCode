/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Queue<UndirectedGraphNode[]> queue = new LinkedList<UndirectedGraphNode[]>();
        UndirectedGraphNode rootNode = new UndirectedGraphNode(node.label);
        queue.add(new UndirectedGraphNode[] {rootNode, node});
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
        visited.put(node.label, rootNode);
        while(!queue.isEmpty()) {
            UndirectedGraphNode[] nodes = queue.poll();
            UndirectedGraphNode newNode = nodes[0];
            UndirectedGraphNode oldNode = nodes[1];
            for(UndirectedGraphNode neighbor : oldNode.neighbors) {
                if(!visited.containsKey(neighbor.label)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor.label, newNeighbor);
                    newNode.neighbors.add(newNeighbor);
                    queue.add(new UndirectedGraphNode[] {newNeighbor, neighbor});
                } else {
                    UndirectedGraphNode newNeighbor = visited.get(neighbor.label);
                    newNode.neighbors.add(newNeighbor);
                }
            }
        }
        return rootNode;
    }
}
