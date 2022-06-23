package com.coderlucifar.leetcode.week04.recursion;

/**
 *  反转链表：
 *      不推荐用递归实现，下面用递归实践。
 *
 */
public class SwordToOffer24 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            //特殊情况处理
            if (head == null) return null;
            ListNode newHead = reverseListImpl(head);
            return newHead;
        }

        private ListNode reverseListImpl(ListNode node) {
            //求解子问题
            if (node.next != null) {
                ListNode newHead = reverseListImpl(node.next);
                //利用子问题的解求解原问题
                node.next.next = node;
                node.next = null;
                return newHead;
            } else {
                //递归出口
                return node;
            }
        }

    }
}
