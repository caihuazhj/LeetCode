package LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode cur=pre;
        while (cur.next!=null){
            if (cur.next.val ==val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
