package com.coderlucifar.leetcode.week06.binarytree.type4;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 后继者(中等)
 *    设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *    如果指定节点没有对应的“下一个”节点，则返回null。
 *
 *    中序遍历，从右往左处理，找到目标节点就提前终止递归
 *
 */
public class Gold0406 {
    class Solution {
        // 存储当前遍历到的不等与p的节点
        private TreeNode q = null;
        // 用来表示是否找到
        private boolean find = false;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) return null;
            inorderTraversal(root, p);
            return q;
        }

        /**
         * 在中序遍历过程中对节点进行处理
         * @param root
         * @param p
         */
        private void inorderTraversal(TreeNode root, TreeNode p) {
            if (root.right != null) {
                inorderTraversal(root.right, p);
                if (this.find == true) return;
            }

            if (root != p) {
                this.q = root;
            } else {
                this.find = true;
                return;
            }

            if (root.left != null) {
                inorderTraversal(root.left, p);
                if (this.find == true) return;
            }
            return;
        }

    }
}
