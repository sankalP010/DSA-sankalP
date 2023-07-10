/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // The tree is empty, so the depth is 0.
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 1; // Start with depth 1 since the root is considered at depth 1.
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Traverse all the nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // Check if the current node is a leaf node
                if (currentNode.left == null && currentNode.right == null) {
                    return minDepth; // Return the minimum depth when a leaf node is found.
                }
                
                // Add the children of the current node to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            minDepth++; // Increment the depth after processing each level
        }
        
        return minDepth;
    }
}
