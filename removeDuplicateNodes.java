/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 */
class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        int[] set = new int[20000 / 32 + 1];
        while (cur != null && cur.next != null) {
            set[cur.val / 32] |= 1 << (cur.val % 32);
            int flag = set[cur.next.val / 32] & 
                        1 << (cur.next.val % 32);
            if (flag != 0) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
	
	public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            set.add(cur.val);
            while (cur.next != null && 
                    set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
	
}