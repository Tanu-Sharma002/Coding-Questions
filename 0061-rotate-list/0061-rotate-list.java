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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail=head;
        if (k == 0 || head == null || head.next==null) {
            return head;
        }
        int count = 1;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        k = k % count;
        if(k==0){
            return head;
        }
        tail.next = head;
        ListNode t = head;
        int n= count-k;
        for (int i = 1; i < n; i++) {
            t= t.next ;
        }
        ListNode temp = t.next;
        t.next=null;

        return temp;
    }
}