package com.coderlucifar.leetcode.week02.linklist;

/**
 * leetcode234: 回文链表
 *      请判断一个链表是否为回文链表
 */
public class Listcode234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return false;

            ListNode reverseHead = reverse(head);
            ListNode p1 = head;
            ListNode p2 = reverseHead;
            while (p1 != null) {
                if (p1.val == p2.val) {
                    p1 = p1.next;
                    p2 = p2.next;
                } else {
                    return false;
                }
            }
            return true;
        }

        /**
         * 传入一个链表，并返回一个新链表，该新链表的每个节点的值与原来的排列顺序相反
         * @param head
         * @return
         */
        private ListNode reverse(ListNode head) {
            ListNode newHead = new ListNode();
            newHead.next = null;
            ListNode p = head;
            while (p != null) {
                ListNode tmp = p.next;
                ListNode node = new ListNode(p.val);
                node.next = newHead.next;
                newHead.next = node;
                p = tmp;
            }
            return newHead.next;
        }


    }

    public static void main(String[] args) {

    }
}
