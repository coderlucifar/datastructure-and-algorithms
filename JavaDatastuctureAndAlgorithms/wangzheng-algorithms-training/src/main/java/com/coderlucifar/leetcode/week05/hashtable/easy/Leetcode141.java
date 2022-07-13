package com.coderlucifar.leetcode.week05.hashtable.easy;

import com.coderlucifar.leetcode.week05.hashtable.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *  leetcode141: 环形链表
 *     解析：1、这道题我们之前做过，利用快慢指针求解，如果两个指针可以相遇，说明是环形链表。
 *          2、下面我们利用哈希表的思想重新求解这道题目。
 */
public class Leetcode141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode p = head;
            Set<String> set = new HashSet<>();
            while (p != null) {
                if (set.contains(p.toString())) {
                    return true;
                } else {
                    set.add(p.toString());
                }
                p = p.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(12);
        System.out.println(node);
        System.out.println(node.toString());
    }
}
