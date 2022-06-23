package com.coderlucifar.leetcode.week02;

/**
 * leetcode83: 删除排序链表中的重复元素
 *      存在一个按升序排列的链表，给你这个链表的头节点head,
 *      请你删除所有重复的元素，使每个元素只出现一次。
 *      返回同样按升序排列的结果链表。
 */
public class Leetcode83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //如果链表为空，返回空
            if (head == null) return null;
            //申请一个哨兵节点
            ListNode newHead = new ListNode();
            //将哨兵节点的下一个指向头节点
            newHead.next = head;
            //让遍历原链表的指针初始指向头节点的下一个
            ListNode p = head.next;
            //把头节点指为空
            head.next = null;

            ListNode tail = head;

            while (p != null) {
                //保存p的下一个节点
                ListNode tmp = p.next;
                if (p.val != tail.val) {
                    tail.next = p;
                    p.next = null;
                    tail = p;
                }
                p = tmp;
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {

    }
}
