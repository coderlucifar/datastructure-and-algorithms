package com.coderlucifar.leetcode.week02.linklist;

/**
 * leetcode25: K个一组翻转链表(困难)
 *      给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *      k是一个正整数，它的值小于或等于链表的长度。
 *      如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *      进阶：
 *          你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *          你不能只是单纯的改变节点内部的值，而是需要实际进行节点的交换。
 */
public class Leetcode25 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            //哨兵头
            ListNode newHead = new ListNode();
            ListNode tail = newHead;

            ListNode p = head;
            ListNode q = head;
            int count = 1;

            while (p != null && q != null) {
                while (count != k && q.next != null) {
                    count++;
                    q = q.next;
                }
                if (count != k) {
                    tail.next = p;
                    break;
                } else {
                    if(p != null && q != null) {
                        ListNode tmp = q.next;
                        ListNode[] nodes = reverse(p, k);
                        tail.next = nodes[0];
                        tail = nodes[1];
                        p = tmp;
                        q = tmp;
                        count = 1;
                    }
                }
            }
            return newHead.next;
        }

        /**
         * 将链表翻转，返回新的头节点和尾节点
         * @param head
         * @return
         */
        private ListNode[] reverse(ListNode head, final int k) {
            ListNode newHead = new ListNode();
            ListNode p = head;
            int count = 0;
            while (count != k) {
                count++;
                ListNode tmp = p.next;
                p.next = newHead.next;
                newHead.next = p;
                p = tmp;
            }
            return new ListNode[]{newHead.next,head};
        }

    }
    public static void main(String[] args) {

    }
}
