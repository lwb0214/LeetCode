/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 输入:
 * [
 *  1->4->5,
 * 	1->3->4,
 *	2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *

 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
		//PriorityQueue是一个小根堆
        //compareTo(n1.val, n2.val)
        Queue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        for (ListNode node:lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            p.next = minNode;
            p = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        
        return dummyHead.next;
    }
}

//分治法
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }

        int mid = (lo + hi) >>> 1; 
        ListNode left = merge(lists, lo, mid);
        ListNode right = merge(lists, mid + 1, hi);
        
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}