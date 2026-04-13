/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lista = headA;
        ListNode listb = headB;
        while (lista != listb) {
            if (lista != null) {
                lista = lista.next;
            } else {
                lista = headB;
            }
            if (listb != null) {
                listb = listb.next;
            } else {
                listb = headA;
            }
        }
        return lista;
    }
}