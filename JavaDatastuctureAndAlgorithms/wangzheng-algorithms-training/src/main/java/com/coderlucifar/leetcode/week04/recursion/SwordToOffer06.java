package com.coderlucifar.leetcode.week04.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头打印链表
 *
 *      链表的问题其实不推荐用递归的方法求解，
 *      这里用递归的方法求解完全是老师为了满足一些学生的要求用递归实现，
 *      但是老师并不推荐，还是推荐用哨兵节点，尾指针等技巧实现。
 *
 *      链表问题用递归解决并不利于理解，并且函数调用本身也具有时间开销，如果链表节点太多，
 *      问题规模太大，很有可能会运行超时。
 */
public class SwordToOffer06 {
    class Solution {
        public int[] reversePrint(ListNode head) {
            // 特殊情况判定
            if (head == null) return null;
            // 创建一个list用于保存最终结果
            List<Integer> list = new ArrayList();
            //递归方法
            reversePrint(head, list);
            //构造返回结果
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
        private void reversePrint(ListNode node, List<Integer> list) {
            if (node.next != null) {
                reversePrint(node.next, list);
            }
            list.add(node.val);
        }
    }
}
