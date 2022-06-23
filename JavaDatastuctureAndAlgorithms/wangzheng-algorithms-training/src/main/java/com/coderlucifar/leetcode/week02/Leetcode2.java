package com.coderlucifar.leetcode.week02;

/**
 * leetcode2：两数相加
 *      给你两个非空的链表，表示两个非负的整数。
 *      它们每位数字都是按照逆序的方式存储的，
 *      并且每个节点只能存储一位数字。
 *      请你将两个数相加，并以相同形式返回一个表示和的链表。
 *      你可以假设除了数字0之外，这两个数都不会以0开头。
 */
public class Leetcode2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode newHead = new ListNode();
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode tail = newHead;
            int increasePlace = 0;  //用于存两数相加进位的数
            int newVal = 0;
            int sum = 0;
            while (p1 != null && p2 != null) {
                sum = p1.val + p2.val + increasePlace;
                if (sum >= 10) {
                    newVal = sum % 10;
                    increasePlace = 1;
                } else {
                    newVal = sum;
                    increasePlace = 0;
                }
                ListNode node = new ListNode(newVal);
                tail.next = node;
                node.next = null;
                tail = node;
                p1 = p1.next;
                p2 = p2.next;
            }
            ListNode p = null;
            if (p1 != null){
                p = p1;
                p.next = p1.next;
            }
            if (p2 != null) {
                p = p2;
                p.next = p2.next;
            }
            while (p != null) {
                sum = p.val + increasePlace;
                if (sum >= 10) {
                    newVal = sum % 10;
                    increasePlace = 1;
                } else {
                    newVal = sum;
                    increasePlace = 0;
                }
                ListNode node = new ListNode(newVal);
                tail.next = node;
                node.next = null;
                tail = node;
                p = p.next;
            }
            if (increasePlace == 1) {
                tail.next = new ListNode(1);
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {

    }
}
