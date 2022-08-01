package com.coderlucifar.leetcode.week06.binarytree.type7;

/**
 * leetcode889：根据前序和后序遍历构造二叉树(中等)
 *      给定两个整数数组，preorder和 postorder ，
 *      其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，
 *      postorder 是同一棵树的后序遍历，重构并返回二叉树。
 *      如果存在多个答案，您可以返回其中 任何 一个。
 *
 *  分析:
 *      这道题目由于没有中序遍历结果，没有办法唯一划分左右子树来确定二叉树的结果。
 *      我们利用前序遍历序列的另一个特点：
 *          从之前的知识里我们知道前序遍历序列的第一个值是根节点，
 *          其实，前序遍历序列的第二个节点可能是左子树的根节点(如果没有左子树的情况下，也有可能是右子树的根节点)。
 *          我们利用这个特点来划分左右子树从而可以得到一个可行的解。
 */
public class Leetcode889 {

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

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return constructFromPrePost_r(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
        }

        private TreeNode constructFromPrePost_r(int[] preorder, int i, int j, int[] postorder, int l, int r) {
            if (i > j) return null;
//            // 因为前序序列区间长度缩减到1时，有没有相邻节点了，没法继续找子树的根节点。
//            if (i == j) return null;

            TreeNode tree = new TreeNode(preorder[i]);
            // 如果 i==j 说明没有左右子树了，直接返回创建的节点
            // 如果不加这句，那么 preorder[i+1]就可能造成数组下标越界。
            if (i == j) return tree;

            // 寻找左右子树的区间
            // 获取左子树根节点的值（也可能是右子树根节点的值）
            int childRootValue = preorder[i+1];
            // 在后序遍历序列中找左子树的根节点从而确定左子树后序遍历序列的右边界
            int p = l;
            while (postorder[p] != childRootValue) {
                p++;
            }
            int leftSize = p-l+1;

            // 构造左子树
            TreeNode leftChild = constructFromPrePost_r(preorder, i + 1, i + leftSize, postorder, l, p);
            // 构造右子树
            TreeNode rightChild = constructFromPrePost_r(preorder, i + leftSize + 1, j, postorder, p + 1, r - 1);
            tree.left = leftChild;
            tree.right = rightChild;
            return tree;
        }

    }
}
