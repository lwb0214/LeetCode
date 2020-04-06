/***
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 ***/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        int carry=0;
        ListNode res=new ListNode(-1);
        ListNode p=res;
        while(l1!=null && l2!=null){
            int val=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            p.next=new ListNode(val);
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int val=(l1.val+carry)%10;
            carry=(l1.val+carry)/10;
            p.next=new ListNode(val);
            p=p.next;
            l1=l1.next;
        }
        while(l2!=null){
            int val=(l2.val+carry)%10;
            carry=(l2.val+carry)/10;
            p.next=new ListNode(val);
            p=p.next;
            l2=l2.next;
        }
		/***	简化版
		 while(l1!=null || l2!=null){
            int sum= (l1==null?0:l1.val) + (l2==null?0:l2.val) +carry;
            int val=sum%10;
            carry=sum/10;
            p.next=new ListNode(val);
            p=p.next;
            l1=(l1==null)?l1:l1.next;
            l2=(l2==null)?l2:l2.next;
        }
		***/
        if(carry!=0){
            p.next=new ListNode(carry);
        }
        return res.next;
    }
}