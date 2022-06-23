package com.coderlucifar.leetcode.week02;

/**
 * leetcode19：删除链表中的倒数第N个节点(中等)
 *      给你一个链表，删除链表的倒数第n个节点，并且返回链表的头节点。
 *      进阶：你能尝试使用一趟扫描实现吗？
 */
public class Leetcode19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode fast = head;
            int count = 1;
            while (fast != null) {
                if (count == n) break;
                fast = fast.next;
                count++;
            }
            if (fast == null) return head;

            ListNode pre = head;
            ListNode slow = head;
            //找待删除节点的位置，循环结束后就是slow指针指向的位置
            while (fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next;
            }

            if (slow != head) {
                pre.next = slow.next;
                slow.next = null;
            } else {
                return head.next;
            }

            return head;
        }
    }

    public static void main(String[] args) {

    }
}
