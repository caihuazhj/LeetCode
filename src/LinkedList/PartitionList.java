package LinkedList;

public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode partition(ListNode head, int x) {

        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode node = head, less = small, greater = big;
        while (node!=null){
            ListNode next = node.next;
            if (node.val < x) {
                less.next = node;
                less = less.next;
                less.next = null;
            } else {
                greater.next = node;
                greater = greater.next;
                greater.next = null;
            }
            node = next;
        }
        less.next = big.next;
        return small.next;


    }
}
