package com.coderlucifar.leetcode.week06.binarytree.type2;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 找树左下角的值(中等)
 *      给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *      假设二叉树中至少有一个节点。
 *
 *  解法一：从右往左层序遍历，最后一个值。
 */
public class Leetcode513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) return -1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            Stack<Integer> stack = new Stack<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                stack.push(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            int pop = stack.pop();
            return pop;
        }
    }
}
