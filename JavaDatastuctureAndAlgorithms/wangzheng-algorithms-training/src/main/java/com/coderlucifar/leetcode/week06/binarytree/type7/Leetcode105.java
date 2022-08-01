package com.coderlucifar.leetcode.week06.binarytree.type7;

import com.coderlucifar.leetcode.week06.binarytree.type6.Gold1712;

/**
 * leetcode105：从前序与中序遍历序列构造二叉树(中等)
 *      给定两个整数数组preorder 和 inorder，
 *      其中preorder 是二叉树的先序遍历，
 *      inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *      提示:
 *          1 <= preorder.length <= 3000
 *          inorder.length == preorder.length
 *          -3000 <= preorder[i], inorder[i] <= 3000
 *          preorder和inorder均 无重复 元素
 *          inorder均出现在preorder
 *          preorder保证 为二叉树的前序遍历序列
 *          inorder保证 为二叉树的中序遍历序列
 */
public class Leetcode105 {



    class Solution {
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
               return buildTree_r(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }

        private TreeNode buildTree_r(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
            if (pl > pr) return null;
            if (il > ir) return null;
            TreeNode tree = new TreeNode(preorder[pl]);
            // 寻找左子树前序与中序的区间，寻找右子树的前序与中序区间
            // 获取当前树的根
            int root = pl;
            int p = il;
            // 在中序遍历区间中寻找根节点的位置 , 循环结束后，p为中序遍历区间中的根节点位置。
            while (inorder[p] != preorder[root]) {
                p++;
            }
            int leftSize = p - il;

            // 构造左子树
            TreeNode leftTree = buildTree_r(preorder, pl + 1, pl+leftSize, inorder, il, p - 1);
            // 构造右子树
            TreeNode rightTree = buildTree_r(preorder, pl+leftSize+1, pr, inorder, p + 1, ir);
            tree.left = leftTree;
            tree.right = rightTree;
            return tree;
        }


    }
}
