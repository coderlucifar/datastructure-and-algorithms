package com.coderlucifar.leetcode.week02.linklist;

/**
 * leetcode141: 环形链表    判断链表中是否存在环
 *      如果链表中有某个节点，可以通过连续跟踪next指针再次到达，则链表中存在环。
 *      为了表示给定链表中的环，评测系统内部使用整数pos来表示链表尾连接到链表中的位置(索引从0开始)。
 *      如果pos是-1，则在该链表中没有环。
 *
 *      注意：pos不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *      如果链表中存在环，则返回true。
 *      否则，返回false。
 *
 *      解法：用快慢指针，如果能相遇，就是有环。
 */
public class Leetcode141 {
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                }else {
                    return false;
                }
                if ((slow == fast) && slow != null) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
