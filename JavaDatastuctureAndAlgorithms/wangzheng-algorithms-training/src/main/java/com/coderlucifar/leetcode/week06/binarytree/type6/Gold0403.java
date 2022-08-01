package com.coderlucifar.leetcode.week06.binarytree.type6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 特定深度节点链表（中等）
 *      给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 *      （比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 *      返回一个包含所有深度的链表的数组。
 */
public class Gold0403 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public class StackFrame {
        int level;
        TreeNode node;
        public StackFrame(int _level, TreeNode _node) {
            this.level = _level;
            this.node = _node;
        }
    }

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) return new ListNode[]{};
            // 结果集
            List<ListNode> result = new ArrayList<>();
            // 层序遍历过程中构造结果
            // 申请队列
            Queue<StackFrame> queue = new LinkedList<>();
            // 添加根节点入队
            queue.add(new StackFrame(0, tree));
            // 循环队列处理每个节点
            ListNode newHead = null;
            ListNode tail = null;
            while(!queue.isEmpty()) {
                StackFrame stackFrame = queue.poll();
                // 扩充层数的条件
                if (stackFrame.level > result.size()-1) {
                    // 申请新的头节点
                    newHead = new ListNode(stackFrame.node.val);
                    tail = newHead;
                    tail.next = null;
                    result.add(newHead);
                } else {
                    ListNode node = new ListNode(stackFrame.node.val);
                    tail.next = node;
                    tail = node;
                    tail.next = null;
                }
                if (stackFrame.node.left != null) {
                    queue.add(new StackFrame(stackFrame.level+1, stackFrame.node.left));
                }
                if (stackFrame.node.right != null) {
                    queue.add(new StackFrame(stackFrame.level+1, stackFrame.node.right));
                }
            }
            //构造返回结果
            ListNode[] res = new ListNode[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Gold0403 gold0403 = new Gold0403();
        Solution solution = gold0403.new Solution();
        TreeNode tree = new Gold0403().new TreeNode(1);
        TreeNode node1 = new Gold0403().new TreeNode(2);
        TreeNode node2 = new Gold0403().new TreeNode(3);
        tree.left = node1;
        tree.right = node2;
        TreeNode node3 = new Gold0403().new TreeNode(7);
        node2.right = node3;
        node2.left = null;
        TreeNode node4 = new Gold0403().new TreeNode(4);
        TreeNode node5 = new Gold0403().new TreeNode(5);
        node1.left = node4;
        node1.right = node5;
        node5.left = null;
        node5.right = null;
        TreeNode node6 = new Gold0403().new TreeNode(8);
        node4.left = node6;
        node4.right = null;
        solution.listOfDepth(tree);
    }

}
