package com.coderlucifar.leetcode.week05.hashtable.easy;

import com.coderlucifar.leetcode.week05.hashtable.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode160：相交链表
 *    解法一：使用快慢指针，较长的链表先走两个链表长度的差值，然后两个指针再一起走，
 *    边走边判断指向的地址是否相等，遍历完成前，如果相等就存在相交节点。
 *
 *    解法二：利用哈希表，先将一个链表遍历完，将所有节点的地址都存入哈希表，
 *    然后遍历第二个链表，每遍历一个就检查在哈希表中是否存在，如果已经存在，
 *    说明是相交链表。
 */
public class Leetcode160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode p = headA;
            Set<String> set = new HashSet<>();
            while (p != null) {
                set.add(p.toString());
                p = p.next;
            }
            ListNode q = headB;
            while (q != null) {
                if (set.contains(q.toString())) {
                    return q;
                }
                q = q.next;
            }
            return null;
        }
    }
}
