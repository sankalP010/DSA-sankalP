import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; // Number of nodes in the graph
        
        // Create an array to track the state of each node
        // 0: Not visited
        // 1: Visited but part of a cycle
        // 2: Visited and confirmed safe
        int[] state = new int[n];
        
        List<Integer> safeNodes = new ArrayList<>();
        
        // Perform DFS from each node
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i, state)) {
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    private boolean isSafe(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            // If the state is not 0, it means we have already visited this node
            // If state[node] == 1, it means this node is part of a cycle and not safe
            // If state[node] == 2, it means this node is already confirmed as safe
            return state[node] == 2;
        }
        
        // Mark the current node as visited but part of a cycle
        state[node] = 1;
        
        // Recursively check all the neighbors of the current node
        for (int neighbor : graph[node]) {
            if (!isSafe(graph, neighbor, state)) {
                return false; // If any neighbor is not safe, the current node is also not safe
            }
        }
        
        // If all neighbors are safe, mark the current node as confirmed safe
        state[node] = 2;
        
        return true;
    }
}
