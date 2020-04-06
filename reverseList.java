/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //解法一：递归
 //关键点：head.next.next=head;
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next==null){
            return head;
        }
        ListNode new_head = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return new_head;
    }
}
//解法二：双指针迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }
}