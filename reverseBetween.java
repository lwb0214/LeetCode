/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==1){
            return reverseFirstN(head,n);
        }
        head.next=reverseBetween(head.next,m-1,n-1);
        return head;
    }
    private static ListNode reverseFirstN(ListNode head, int n) {
        if (n == 1) return head;
        ListNode newHead = reverseFirstN(head.next, n - 1);
        ListNode rNext = head.next.next;
        head.next.next = head;
        head.next = rNext;
        return newHead;
    }
}