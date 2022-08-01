package com.coderlucifar.leetcode.week06.binarytree.type4;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 把二叉搜索树转换为累加树（中等）
 */
public class Leetcode538 {
    class Solution {

        // 用来存储当前的累加值
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) return root;
            inorderTraversal(root);
            return root;
        }

        /**
         * 中序遍历，在遍历过程中处理节点值
         * @param root
         */
        private void inorderTraversal(TreeNode root) {
            if (root.right != null) {
                inorderTraversal(root.right);
            }
            root.val = root.val + this.sum;
            this.sum = root.val;
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            return ;
        }

    }
}
