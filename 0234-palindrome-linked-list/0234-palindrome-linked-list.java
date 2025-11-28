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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int[] arr = new int[count];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
