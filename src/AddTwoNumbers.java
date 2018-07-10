/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 关键点在于处理进位
 */
public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode p=l1,q=l2,current = res;

        //进位
        int carry =0;
        while (p != null || q != null){
            //获取每个节点的值
            int x = (p!=null?p.val:0);
            int y = (q!=null?q.val:0);
            //计算每一位的值
            int sum = carry +x+y;
            //carry赋值 如果有进位就是1，否则是0
            carry=sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if (p!=null){
                p= p.next;
            }
            if (q!=null){
                q = q.next;
            }
        }
        //如果两个list位数不一样
        if (carry>0){
            current.next = new  ListNode(carry);
        }
        return res.next;
    }
}
