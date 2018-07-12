package LinkedList;
/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
import java.util.HashSet;
import java.util.Set;


public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode first=head;
        ListNode second = head;
        while (second!=null&&second.next!=null){
            first =first.next;
            second = second.next.next;

            if (first == second){
                return true;
            }
        }

            return false;
    }

    /**
     * We go through each node one by one and record each node's reference (or memory address) in a hash table.
     * If the current node is null, we have reached the end of the list and it must not be cyclic.
     * If current node’s reference is in the hash table, then return true.
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head){
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

}
