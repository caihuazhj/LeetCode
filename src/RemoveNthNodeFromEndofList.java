
/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.有效的
 *
 * Follow up:
 *
 * Could you do this in one pass?
 * Answer：This problem is easy to solve once we found list length L.
 */
public class RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //只有一个节点，删除后为空
        if(head.next ==null){
            return null;
        }

        ListNode cur = head,pre=head;
        //cur向前走n个节点
        for(int i=0;i<n;i++){
            cur = cur.next;
        }
        //如果cur为空，说明n=length，去除第一个节点
        if(cur == null){
            return head.next;
        }
        //pre，cur分别移动n位
        while (cur.next!=null){
            cur = cur.next;
            //pre位置为要删除的前一个节点
            pre = pre.next;
        }
        //删除时，前一个节点直接指向下下个节点
        pre.next = pre.next.next;

        return head;


    }
}
