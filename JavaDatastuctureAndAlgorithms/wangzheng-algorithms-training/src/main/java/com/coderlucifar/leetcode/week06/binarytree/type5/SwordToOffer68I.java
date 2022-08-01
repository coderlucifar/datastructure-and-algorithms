package com.coderlucifar.leetcode.week06.binarytree.type5;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先(简单)
 * 说明:
 *      所有节点的值都是唯一的。
 *      p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class SwordToOffer68I {
    class Solution {
        /**
         * 递归实现，从根节点开始往下找，在递的过程中验证是否为最近公共祖先，归的时候什么都不做。
         * 过程就是，根据当前节点的值决定是往左找还是往右找，在这个过程中，找到的第一个复合条件的结果就
         * 是题目的解。
         *
         * 如何分解子问题？
         *      原问题是在二叉树中寻找最近公共祖先。
         *      那么子问题就是在子树中寻找最近公共祖先，前提是当前节点不是满足题意的解，
         *      然后才根据情况来判断具体是在哪个子树中找答案。
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            // 判断当前节点是不是p，q的最近公共祖先
            if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) return root;
            if (root == p || root == q) return root;
            // 如果p，q的节点值都比当前节点值小，在左子树中找
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // 如果p，q的节点值都比当前节点值大，在右子树中找
            else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }

        /**
         *  非递归解法
         */
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                } else if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else {
                    return root;
                }
            }
        }

    }
}
