package com.coderlucifar.leetcode.week04.recursion;

/**
 * 合并两个排序的链表
 */
public class SwordToOffer25 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            return mergeTwoListsImpl(l1, l2);
        }

        private ListNode mergeTwoListsImpl(ListNode l1, ListNode l2) {
            //递归终止条件
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            // 将原问题分解为子问题
            if (l1.val < l2.val) {
                ListNode listNode = mergeTwoLists(l1.next, l2);
                //利用子问题的解求解原问题
                l1.next = listNode;
                return l1;
            } else {
                ListNode listNode = mergeTwoLists(l1, l2.next);
                //利用子问题的解求解原问题
                l2.next = listNode;
                return l2;
            }
        }

    }
}
