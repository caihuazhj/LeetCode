package LinkedList;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode reverseList(ListNode head) {

        if (head == null ||head.next ==null){
            return head;
        }
        ListNode current = head;
        ListNode next =null;
        ListNode reverse = null;

        while (current!=null){
            next = current.next;

            current.next = reverse;
            reverse = current;

            current = next;

        }
        return reverse;
    }


}
