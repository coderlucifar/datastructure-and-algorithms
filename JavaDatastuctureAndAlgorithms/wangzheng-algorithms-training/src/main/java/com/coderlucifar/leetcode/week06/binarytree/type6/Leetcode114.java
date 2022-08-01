package com.coderlucifar.leetcode.week06.binarytree.type6;

/**
 *  leetcode114: 二叉树展开为链表(中等)   20220727
 *      给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *      展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *      展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *      将一个二叉树先序展开为单链表
 *
 */
public class Leetcode114 {

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

    private TreeNode newHead = new TreeNode();
    private TreeNode tail = newHead;
    class Solution {
        public void flatten(TreeNode root) {
            preorderTraversal(root);
        }

        /**
         * 在前序遍历过程中将二叉树转换为单链表
         */
        private void preorderTraversal(TreeNode root) {
            if (root == null) return;
            TreeNode left = root.left;
            TreeNode right = root.right;

            tail.right = root;
            tail = root;
            tail.left = null;

            if (left != null) {
                preorderTraversal(root.left);
            }
            if (right != null) {
                preorderTraversal(root.right);
            }
            return;
        }
    }
}
