package com.coderlucifar.leetcode.week02.linklist;

/**
 * 剑指Offer25. 合并两个排序的链表
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class SwordToOffer25 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode newHead = new ListNode();
            ListNode tail = newHead;
            ListNode p1 = l1;
            ListNode p2 = l2;

            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    ListNode tmp = p1.next;
                    tail.next = p1;
                    p1.next = null;
                    tail = p1;
                    p1 = tmp;
                }else {
                    ListNode tmp = p2.next;
                    tail.next = p2;
                    p2.next = null;
                    tail = p2;
                    p2 = tmp;
                }
            }
            if (p1 == null) {
                tail.next = p2;
            }
            if (p2 == null) {
                tail.next = p1;
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {

    }
}
