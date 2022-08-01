package com.coderlucifar.leetcode.week06.binarytree.type7;

/**
 * leetcode106：从中序与后序遍历序列构造二叉树(中等)
 *      给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 */
public class Leetcode106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree_r(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        }

        private TreeNode buildTree_r(int[] inorder, int i, int j, int[] postorder, int l, int r) {
            if (i > j) return null;
            if (l > r) return null;

            TreeNode tree = new TreeNode(postorder[r]);

            int rootValue = postorder[r];
            int p = i;
            while (inorder[p] != rootValue) {
                p++;
            }

            int rightSize = j - p;

            TreeNode leftTree = buildTree_r(inorder, i, p - 1, postorder, l, r - rightSize - 1);
            TreeNode rightTree = buildTree_r(inorder, p + 1, j, postorder, r - rightSize, r - 1);
            tree.left = leftTree;
            tree.right = rightTree;
            return tree;
        }

    }
}
