/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int count=0;
        ListNode temp=head;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        int nums[]=new int[count];
        ListNode t=head;
        int i=0;
        while(i<count){
            nums[i]=t.val;
            i++;
            t=t.next;
        }
        return BST(nums,0,nums.length-1);
    }
    private TreeNode BST(int[] nums,int left,int right){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=BST(nums,left,mid-1);
        root.right=BST(nums,mid+1,right);
        return root;
    }
}