package com.coderlucifar.leetcode.week02.linklist;

/**
 * leetcode160: 相交链表(简单)
 *      给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。
 *      如果两个链表不存在相交节点，返回null。
 */
public class Leetcode160 {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while (p != null) {
                while (q != null) {
                    if (p == q) {
                        if (q != null && q.val != 0) return q;
                    }
                    q = q.next;
                }
                p = p.next;
                q = headB;
            }
            return null;
        }
    }
}
