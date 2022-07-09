package com.coderlucifar.leetcode.week02.linklist;

/**
 * leetcode328: 奇偶链表(中等)
 *      给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 *      请注意，这里的奇数节点好偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 */
public class Leetcode328 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;

            ListNode oddHead = new ListNode();
            ListNode oddTail = oddHead;
            ListNode evenHead = new ListNode();
            ListNode evenTail = evenHead;
            ListNode p = head;
            int i = 1;
            while (p != null) {
                ListNode tmp = p.next;
                if (i % 2 == 1) {
                    oddTail.next = p;
                    p.next = null;
                    oddTail = p;
                }else {
                    evenTail.next = p;
                    p.next = null;
                    evenTail = p;
                }
                p = tmp;
                i++;
            }
            oddTail.next = evenHead.next;
            return oddHead.next;
        }
    }

    public static void main(String[] args) {

    }
}
