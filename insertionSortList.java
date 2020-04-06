/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        while(head!=null && head.next!=null){
            if(head.val <= head.next.val){
                head=head.next;
            }
            else{
                ListNode pre=dummy;
                //找到大于无序结点的结点pre.next
                while(pre.next.val < head.next.val) pre=pre.next;
                //移动结点
                ListNode tmp=head.next;
                head.next=tmp.next;
                tmp.next=pre.next;
                pre.next=tmp;
            }
        }
        return dummy.next;
    }
}

//插入排序
 public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {//如果第i个数大于前一个数就不用判断了,
				//因为前面都是有序数列,大于前一个数肯定比前面所有数都大,
				//否则的话把这个数拿出来也就是赋值给temp,然后依次与前面的数比较,
                int temp = array[i];
                int j = i;
				//如果比前一个数小就让前一个数往后挪一位直到找到比temp小的位置放进去
                for (; j >= 1 && array[j - 1] > temp; j--) {
                    array[j] = array[j-1];
                }
            array[j] = temp;
            }
        }
    }