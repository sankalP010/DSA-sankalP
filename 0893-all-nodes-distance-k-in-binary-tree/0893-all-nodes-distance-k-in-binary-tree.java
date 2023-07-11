/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        // Build a map of each node's parent
        buildParentMap(root, null, parentMap);

        // Perform DFS from the target node
        dfs(target, k, parentMap, visited, result);

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null)
            return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    private void dfs(TreeNode node, int k, Map<TreeNode, TreeNode> parentMap, Set<TreeNode> visited, List<Integer> result) {
        if (node == null || visited.contains(node))
            return;
        visited.add(node);

        if (k == 0) {
            result.add(node.val);
            return;
        }

        dfs(node.left, k - 1, parentMap, visited, result);
        dfs(node.right, k - 1, parentMap, visited, result);
        dfs(parentMap.get(node), k - 1, parentMap, visited, result);
    }
}
