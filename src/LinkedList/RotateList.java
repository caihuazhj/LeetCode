package LinkedList;


/**
 * Given a linked list, rotate the list to the right by k places,
 * where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *  这题首先要考虑 k可以大于length 所以计算前要先取模
 *
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null|| k==0){
            return head;
        }
        int length = getLength(head);
        k = k%length;
        if (k==0){
            return head;
        }
        ListNode fast =head;
        ListNode slow =head;
        ListNode newhead = new ListNode(-1);

        //将快指针移动到k处
        for (int i=0;i<k;i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        newhead = slow.next;
        fast.next = head;
        slow.next = null;

        return newhead;

    }

    public int getLength(ListNode head){
        int count =0;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;

    }

}
