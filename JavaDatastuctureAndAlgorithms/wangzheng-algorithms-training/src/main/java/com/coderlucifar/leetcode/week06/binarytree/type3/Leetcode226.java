package com.coderlucifar.leetcode.week06.binarytree.type3;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 翻转二叉树（简单）
 */
public class Leetcode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode leftNode = invertTree(root.left);
            TreeNode rightNode = invertTree(root.right);
            root.left = rightNode;
            root.right = leftNode;
            return root;
        }
    }
}
