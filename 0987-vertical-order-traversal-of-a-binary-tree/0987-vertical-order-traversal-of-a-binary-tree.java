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

    class Tuple {
        TreeNode node;
        int row, col;
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode curr = t.node;
            int row = t.row;
            int col = t.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, curr.val});
            
            if (curr.left != null)
                q.offer(new Tuple(curr.left, row + 1, col - 1));

            if (curr.right != null)
                q.offer(new Tuple(curr.right, row + 1, col + 1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];  // same row → sort by value
                return a[0] - b[0];                    // otherwise sort by row
            });
            List<Integer> colVals = new ArrayList<>();
            for (int[] arr : list)
                colVals.add(arr[1]);

            ans.add(colVals);
        }
        return ans;
    }
}
