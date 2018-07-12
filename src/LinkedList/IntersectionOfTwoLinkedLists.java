package LinkedList;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */


public class IntersectionOfTwoLinkedLists {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public int getLength(ListNode node){
        if (node ==null){
            return 0;
        }
        int n = 0;
        while (node!=null){
            n++;
            node = node.next;
        }
        return n;
    }
    //leetcode 一种巧妙的解法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA ==null || headB == null){
            return  null;
        }
        ListNode p = headA;
        ListNode q = headB;
        //暴力破解需要getLength
//        while (p!=null &&q!=null){
//            if (p==q){
//                return p;
//            }
//
//            p = p.next;
//            q= q.next;
//        }
        while (p!=q){
            p = (p == null)? headB : p.next;
            q = (q == null)? headA : q.next;
        }
        return p;
    }

    //hashSet
    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        if (headA ==null || headB == null){
            return  null;
        }

        Set<ListNode> seta = new HashSet<ListNode>();
        while (headA != null){
            seta.add(headA);
            headA = headA.next;
        }
        while (headB !=null){
            if (seta.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return  null;
    }

    public ListNode getFirstCommonNode(ListNode headA, ListNode headB) {
        if (headA ==null || headB == null){
            return  null;
        }
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        int lengthdiff ;

        ListNode longList,shortList;
        if(length1>length2){
            longList = headA;
            shortList = headB;
            lengthdiff = length1-length2;

        }else {
            longList = headB;
            shortList = headA;
            lengthdiff = length2-length1;
        }

        //将较长的list前移lengthdiff位
        for (int i=0;i<lengthdiff;i++){
            longList = longList.next;
        }
        while (longList!=null && shortList!=null){
            if(longList == shortList){
                return longList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }
        return null;

    }
}
