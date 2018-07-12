package LinkedList;
/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 */
public class RemoveDuplicatesfromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode before =new ListNode(0);
        before.next = head;
        ListNode current  = head;
        ListNode pre = before;
        while (current!=null){
            //通过循环跳过重复值
            while (current.next!=null && current.val == current.next.val){
                current = current.next;
            }
            //说明没有重复值
            if (pre.next == current){
                pre = pre.next;
            }else {
                pre.next = current.next;
            }
            current = current.next;
        }
        return  before;


    }
}
