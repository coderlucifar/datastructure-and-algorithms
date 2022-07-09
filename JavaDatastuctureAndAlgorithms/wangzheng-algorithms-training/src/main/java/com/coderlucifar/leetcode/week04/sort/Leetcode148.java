package com.coderlucifar.leetcode.week04.sort;

import java.util.List;

/**
 * leetcode148：排序链表(中等)
 *      给你链表的头节点head，请将其按生序排列并返回排序后的链表。
 *
 * 提示：
 *
 * 链表中节点的数目在范围[0, 5 * 104]内
 * -105<= Node.val <= 105
 * 进阶：你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 求解：可以使用归并排序的思想求解
 *
 */
public class Leetcode148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSortList(head);
        }

        /**
         * 对链表进行归并排序
         * @param head
         * @return
         */
        private ListNode mergeSortList(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode midNode = findMid(head);
            ListNode midNodeNext = midNode.next;
            midNode.next = null;
            ListNode leftHead = mergeSortList(head);
            ListNode rightHead = mergeSortList(midNodeNext);
            return mergeList(leftHead, rightHead);
        }

        /**
         * 找中间节点
         * 解法：利用快慢指针找中间节点
         * @param head
         * @return
         */
        private ListNode findMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        /**
         * 合并两个有序链表
         * @param headA
         * @param headB
         * @return
         */
        private ListNode mergeList(ListNode headA, ListNode headB) {
            //边界情况处理
            if (headA == null) return headB;
            if (headB == null) return headA;
            //申请哨兵节点
            ListNode newHead = new ListNode(Integer.MIN_VALUE);
            //尾指针
            ListNode tail = newHead;
            ListNode p = headA;
            ListNode q = headB;
            while (p != null && q != null) {
                if (p.val <= q.val) {
                    ListNode tmp = p.next;
                    tail.next = p;
                    p.next = null;
                    tail = p;
                    p = tmp;
                } else {
                    ListNode tmp = q.next;
                    tail.next = q;
                    q.next = null;
                    tail = q;
                    q = tmp;
                }
            }
            if (p != null) {
                tail.next = p;
            }
            if (q != null) {
                tail.next = q;
            }
            return newHead.next;
        }

    }

}
