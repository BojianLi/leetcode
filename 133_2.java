/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for(UndirectedGraphNode neighbor : n.neighbors) {
                if(map.containsKey(neighbor)) {
                    map.get(n).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                    map.get(n).neighbors.add(neighborCopy);
                }
            }
        }
        return nodeCopy;
    }
}
