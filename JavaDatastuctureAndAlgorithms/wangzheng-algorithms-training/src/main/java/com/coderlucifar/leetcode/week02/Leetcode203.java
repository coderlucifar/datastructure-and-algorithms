package com.coderlucifar.leetcode.week02;

/**
 * leetcode203：移除链表元素
 *      给你一个链表的头节点 head 和一个整数 val ，
 *      请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *      1、2、3标记出的代码有冗余，可以优化
 *
 */
public class Leetcode203 {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            //头节点为空时的处理
            if (head == null) return null;

            //定义一个哨兵节点
            ListNode newHead = new ListNode();
            //定义一个尾节点先指向哨兵节点
            ListNode tail = newHead;
            ListNode p = head;
            while (p != null) {
                //如果当前p指针指向的节点值不为val
                if (p.val != val) {
                    //先保存p的下一个
                    ListNode temp = p.next;                     //1
                    //将当前p指针指向的节点插入到新链表的尾节点后面
                    tail.next = p;
                    p.next = null;
                    tail = p;
                    p = temp;       //可以优化，把else语句去掉     //2
                } else {
                    //如果当前指针指向的节点值为val
                    //指针后移
                    p = p.next;                                 //3
                }
            }
            return newHead.next;
        }
    }
}


