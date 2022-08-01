package com.coderlucifar.leetcode.week06.binarytree.type3;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 平衡二叉树（简单）
 *  输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 *  如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  解法一：求解当前二叉树的深度，在求解过程中判断左右子树的深度差，如果超过一就不满足题意
 */
public class SwordToOffer55II {
    class Solution {
        private boolean balance = true;
        public boolean isBalanced(TreeNode root) {
            if (root == null) return balance;
            deep(root);
            return balance;
        }

        /**
         * 递归求解二叉树的深度
         * @param node
         * @return
         */
        private int deep(TreeNode node) {
            int leftTreeDeep = 0;
            int rightTreeDeep = 0;
            if (node.left != null) {
                leftTreeDeep = deep(node.left);
                if (balance == false) return 0;
            }
            if (node.right != null) {
                rightTreeDeep = deep(node.right);
                if (balance == false) return 0;
            }
            int max = Math.max(leftTreeDeep, rightTreeDeep);
            int min = Math.min(leftTreeDeep, rightTreeDeep);
            if (max - min > 1) balance = false;
            // 返回当前二叉树的最大深度
            return max + 1;
        }

    }
}
