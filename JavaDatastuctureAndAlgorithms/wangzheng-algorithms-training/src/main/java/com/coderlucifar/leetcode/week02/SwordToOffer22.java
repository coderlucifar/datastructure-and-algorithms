package com.coderlucifar.leetcode.week02;

/**
 * 剑指Offer22. 链表中倒数第k个节点 (简单)
 *      输入一个链表，输出该链表中倒数第k个节点。
 *      为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 *      例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 *      这个链表的倒数第3个节点是值为4的节点。
 */
public class SwordToOffer22 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) return null;
            ListNode p = head;
            int n = 0;
            while (p != null) {
                n++;
                p = p.next;
            }
            //返回第index节点
            int index = n - k + 1;
            int i = 1;
            p = head;
            while (i != index) {
                i++;
                p = p.next;
            }
            return p;
        }
    }

    public static void main(String[] args) {

    }
}
