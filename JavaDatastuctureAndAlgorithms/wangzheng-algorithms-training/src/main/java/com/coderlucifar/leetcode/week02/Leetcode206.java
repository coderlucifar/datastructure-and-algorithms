package com.coderlucifar.leetcode.week02;

/**
 * leetcode206: 反转链表
 *  反转一个单链表
 */
public class Leetcode206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode newHead = new ListNode();
            ListNode p = head;
            //使用头插法
            while (p != null) {
                ListNode tmp = p.next;
                p.next = newHead.next;
                newHead.next = p;
                p = tmp;
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {

    }
}
