package LinkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode detectCycle(ListNode head) {

        if (head==null){
            return null;
        }
        ListNode first=head;
        ListNode second = head;
        while (second!=null&&second.next!=null){
            first =first.next;
            second = second.next.next;

            if (first == second){//相等说明有环
                ListNode search = head;//从头开始，相遇即是开始的点

                while (search!=first){
                    search = search.next;
                    first = first.next;
                }
                return search;
            }
        }
        return null;
    }
}
