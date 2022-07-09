package com.coderlucifar.leetcode.week04.sort;

/**
 * leetcode147：对链表进行插入排序(中等):
 *      给定单个链表的头head, 使用插入排序对链表进行排序，
 *      并返回排序后链表的头。
 *
 *  提示：列表的结点数在 [1, 5000]范围内。
 *      -5000 <= Node.val <= 5000
 *
 *      技巧：哨兵节点，尾节点，开始位置，遍历条件，循环终止条件
 *
 */
public class Leetcode147 {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode newHead = new ListNode(-5001);
            ListNode p = head;
            //外层循环处理未排序区间
            while (p != null) {
                ListNode tmp = p.next;
                ListNode q = newHead;
                //在已排序区间寻找插入位置
                while (q.next != null && (p.val >= q.next.val)) {
                    q = q.next;
                }
                //将p指向的节点插入
                p.next = q.next;
                q.next = p;
                //p指针后移
                p = tmp;
            }
            return newHead.next;
        }
    }
}
