package com.coderlucifar.leetcode.week05.hashtable.easy;

import com.coderlucifar.leetcode.week05.hashtable.ListNode;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Set;

/**
 * 程序员面试金典02.01：移除重复节点
 *      编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 *      提示：
 *          1、链表长度在[0, 20000]范围内。
 *          2、链表元素在[0, 20000]范围内。
 *      进阶：
 *          如果不得使用临时缓冲区，该怎么解决？
 *
 *      解法一：使用哈希表轻松秒杀
 *      解法二：如果不使用哈希表，直接在原地求解可以解决么？用什么方法。
 */
public class Gold0201 {
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            ListNode p = head;
            ListNode pre = head;
            Set<Integer> set = new HashSet<>();
            while (p != null) {
                if (!set.contains(p.val)) {
                    set.add(p.val);
                    pre = p;
                    p = p.next;
                } else {
                    p = p.next;
                    pre.next = p;
                }
            }
            return head;
        }
    }
}
