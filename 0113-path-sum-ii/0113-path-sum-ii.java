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
    List<List<Integer>> ans = new ArrayList<>();
    private void dfs(TreeNode root,int targetSum, List<List<Integer>> ans, List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        dfs(root.left, targetSum-root.val, ans,list);
        dfs(root.right, targetSum-root.val, ans,list);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return ans;
        dfs(root,targetSum, ans, list);
        return ans;
    }
}