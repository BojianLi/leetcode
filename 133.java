/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        return dfs(node);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        for(UndirectedGraphNode neighbor : node.neighbors) {
          nodeCopy.neighbors.add(dfs(neighbor));
        }
        return nodeCopy;
    }
}
