package com.coderlucifar.leetcode.week06.binarytree.type3;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 对称二叉树(简单)
 *      给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *      解法一：这个问题如果直接翻译子问题无法求解，需要将问题转换一下。
 *          判断一个二叉树是镜像对称的 等价于 判断左右子树是镜像对称的。
 */
public class Leetcode101 {
    class Solution {
        boolean flag = true;
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return flag;
            symmetric(root.left, root.right);
            return flag;
        }

        private void symmetric(TreeNode root1, TreeNode root2) {
            if (flag == false) return;
            if (root1 == null && root2 == null) return;
            if (root1 == null && root2 != null) {
                flag = false;
                return;
            }
            if (root2 == null && root1 != null) {
                flag = false;
                return;
            }
            if (root1.val != root2.val) {
                flag = false;
                return;
            }
            symmetric(root1.left, root2.right);
            if (flag == false) return;
            symmetric(root1.right, root2.left);
            return;
        }

    }
}
