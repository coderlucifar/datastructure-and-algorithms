package com.coderlucifar.leetcode.week06.binarytree.type5;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 二叉树的最近公共祖先（中等）
 *      给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *      百度百科中最近公共祖先的定义为：
 *          “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *      解法一：最近公共祖先节点满足一个特征，它与左子树一定包含p、q中的一个，它与右子树中一定包含p、q中一的一个。
 *      这种解法某种程度上是利用了最近公共祖先的特征，更为通俗的求解方法是利用回溯。
 */
public class Leetcode236 {
    class Solution {
        private TreeNode lca = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return lca;
            pqNumber(root, p, q);
            return lca;
        }

        /**
         * 递归求解二叉树中p和q的数量，在求解的过程中检查是否满足题意
         * @param root
         * @param p
         * @param q
         * @return
         */
        private int pqNumber(TreeNode root, TreeNode p, TreeNode q) {
            int leftPQNum = 0;
            int rightPQNum = 0;
            if (root.left != null) {
                leftPQNum = pqNumber(root.left, p, q);
                if (lca != null) return 0;
            }
            if (root.right != null) {
                rightPQNum = pqNumber(root.right, p, q);
                if (lca != null) return 0;
            }
            // 检查当前节点是否为p，q的公共祖先
            if ((root == p || root == q) && (leftPQNum == 1 || rightPQNum == 1)) {
                lca = root;
                return 0;
            }
            if (leftPQNum == 1 && rightPQNum == 1) {
                lca = root;
                return 0;
            }
            if (root == p || root == q) return 1 + leftPQNum + rightPQNum;
            else return leftPQNum + rightPQNum;
        }

    }
}
