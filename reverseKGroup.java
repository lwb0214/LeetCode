/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        int count=0;
        ListNode cur=head;
        while(cur!=null && count!=k){
            cur=cur.next;
            count++;
        }
        if(count==k){
            cur=reverseKGroup(cur,k);	//cur为下一块的head
            while(count!=0){
                ListNode next=head.next;
                head.next=cur;
                cur=head;
                head=next;
                count--;
            }
            head=cur;
        }
        return head;
    }
}