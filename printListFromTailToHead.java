/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> res=new LinkedList<>();
        ListNode p=listNode;
        while(p!=null){
            res.addFirst(p.val);
            p=p.next;
        }
        return new ArrayList<Integer>(res);
    }
}