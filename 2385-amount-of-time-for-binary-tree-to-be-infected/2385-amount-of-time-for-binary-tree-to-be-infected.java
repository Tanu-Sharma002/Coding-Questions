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
    public int amountOfTime(TreeNode root, int start) {
        Map <TreeNode,TreeNode> map= new HashMap<>();
        TreeNode startNode = buildParent(root,null,map,start);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode);
        int time=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            time++;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                if(map.get(node) != null && !visited.contains(map.get(node))){
                    visited.add(map.get(node));
                    queue.offer(map.get(node));
                }
            }
        } 
        return time;
    }
    private TreeNode buildParent(TreeNode node,TreeNode parent, Map<TreeNode,TreeNode> map, int start){
        if(node==null) return null;
        map.put(node,parent);
        if(node.val==start) return node;
        TreeNode left = buildParent(node.left,node,map,start);
        if(left != null) return left;
        return buildParent(node.right,node, map,start);
    }
}