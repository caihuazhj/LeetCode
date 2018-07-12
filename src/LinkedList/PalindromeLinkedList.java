package LinkedList;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {

        if (head==null){
            return true;
        }
        ListNode first = head;
        ListNode second = head;
        //利用快慢指针将指针置于中央
        while (second!=null &&second.next!=null){
            first = first.next;
            second = second.next.next;
        }
        //反转后半段链表
        first =reverse(first);
        //将快指针指向head
        second = head;

        while (first!=null){
            if (first.val !=second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
