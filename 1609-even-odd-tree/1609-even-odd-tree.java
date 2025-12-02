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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        int level = 0;

        while (!currentLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.poll();
                if (level % 2 == 0) {
                    if (node.val % 2 == 0 || prev >= node.val) return false;
                } else {
                    if (node.val % 2 == 1 || prev <= node.val) return false;
                }
                prev = node.val;
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            currentLevel = nextLevel;
            level++;
        }
        return true;
    }
}
