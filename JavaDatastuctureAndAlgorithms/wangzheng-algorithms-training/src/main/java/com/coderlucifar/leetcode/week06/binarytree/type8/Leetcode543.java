package com.coderlucifar.leetcode.week06.binarytree.type8;

/**
 *  leetcode543：二叉树的直径 (简单)
 *      给定一棵二叉树，你需要计算它的直径长度。
 *      一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 *      这条路径可能穿过也可能不穿过根结点。
 */
public class Leetcode543 {

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
        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            postorderTraversal(root);
            return max;
        }

        /**
         * 后序遍历依次求解以每个节点为根节点的 最大直径长度
         * 时间复杂度高，因为每个节点都是重复求解的没有复用！
         * 其实我们可以在求解根节点高度的过程中就记录每个节点为根节点的最大直径长度，见Solution2。
         * @param root
         */
        private void postorderTraversal(TreeNode root) {
            if (root == null) return;
            int leftHeight = 0;
            int rightHeight = 0;
            if (root.left != null) {
                postorderTraversal(root.left);
            }
            if (root.right != null) {
                postorderTraversal(root.right);
            }
            int res = height(root.left) + height(root.right) + 2;
            if (res > max) max = res;
            return;
        }

        /**
         * 求树的高度
         * @param node
         * @return
         */
        private int height(TreeNode node) {
            if (node == null) return 0;
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    /**
     * 在求树的高度的过程中，记录左右子树和的最大值，不断更新这个最大值。
     */
    class Solution2 {
        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            height(root);
            return this.max;
        }

        private int height(TreeNode node) {
            if (node == null) return 0;
            int leftTreeHeight = height(node.left);
            int rightTreeHeight = height(node.right);
            if (leftTreeHeight + rightTreeHeight > this.max) {
                this.max = leftTreeHeight + rightTreeHeight;
            }
            return Math.max(leftTreeHeight, rightTreeHeight) + 1;
        }
    }

}
