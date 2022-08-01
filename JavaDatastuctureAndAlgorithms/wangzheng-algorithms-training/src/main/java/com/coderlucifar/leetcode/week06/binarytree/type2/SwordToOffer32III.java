package com.coderlucifar.leetcode.week06.binarytree.type2;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  从上到下打印二叉树 III （中等）
 *      请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *      思考一下：这道题目为啥要借助栈来求解，由此我们可以得到什么启示。
 */
public class SwordToOffer32III {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            // 左边的栈
//            Stack<StackFrame> leftStack = new Stack<>();
            // 右边的栈
//            Stack<StackFrame> rightStack = new Stack<>();
            Stack<TreeNode>[] stacks = new Stack[2];
            for (int i = 0; i < 2; i++) {
                stacks[i] = new Stack<TreeNode>();
            }
            int level = 0;
            // 根节点入栈
            stacks[level%2].push(root);
            while (!stacks[level%2].isEmpty()) {
                // 当前层
                List<Integer> currentLevel = new ArrayList<>();
                // 处理当前层
                while (!stacks[level%2].isEmpty()) {
                    TreeNode node = stacks[level%2].pop();
                    currentLevel.add(node.val);
                    //如果是偶数层
                    if (level % 2 == 0) {
                        if (node.left != null) {
                            stacks[1].push(node.left);
                        }
                        if (node.right != null) {
                            stacks[1].push(node.right);
                        }
                    } else {
                        //如果是奇数层
                        if (node.right != null) {
                            stacks[0].push(node.right);
                        }
                        if (node.left != null) {
                            stacks[0].push(node.left);
                        }
                    }
                }
                level = level + 1;
                result.add(currentLevel);
            }
            return result;
        }
    }
}
