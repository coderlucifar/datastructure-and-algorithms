package com.coderlucifar.leetcode.week02.linklist;

/**
 *  leetcode876题： 链表的中间节点
 *      给定一个头结点为head的非空链表，返回链表的中间结点。
 *      如果有两个中间结点，则返回第二个中间结点。
 *
 *  解法一：先遍历一遍记录所有结点总数n
 *      则第 n/2 + 1 个结点就是我们要找的结点。
 *
 *  解法二：利用快慢指针。慢指针每次走一步，快指针每次走两步。
 *      如果为奇数个结点，当快指针指为空时，慢指针正好指向中间结点。
 *      如果为偶数个结点，当快指针的下一个指为空时，慢指针正好指向中间结点。
 *
 *
 */
public class Leetcode876 {

    class Solution {
        public ListNode middleNode(ListNode head) {

            if (head == null) return null;

            ListNode fast = head;
            ListNode slow = head;

            //当快指针指不为空,或快指针的下一个指针不为空的时候就循环
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {

    }
}
