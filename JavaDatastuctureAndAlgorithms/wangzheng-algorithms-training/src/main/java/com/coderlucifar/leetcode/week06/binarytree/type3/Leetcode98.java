package com.coderlucifar.leetcode.week06.binarytree.type3;

import com.coderlucifar.leetcode.week06.binarytree.TreeNode;

/**
 * 验证二叉搜索树（中等）
 *      分析：首先思考如果直接考虑子问题，如果左右子树都是二叉搜索树，是否可以保证
 *      该树就是二叉搜索树，如果这样分解，子问题无法求解愿问题。
 *
 *      我们需要将问题转化，
 *      如果每个节点的左子树的最大值都比当前节点小，
 *      并且每个节点的右子树的最小值都比当前节点大，
 *      就满足题意。
 *      所以我们需要递归验证每个节点是否满足上述条件，如果遇到不满足的就将
 *      flag设为false，提前终止递归。
 *
 *      提示：
 *          树中节点数目范围在[1, 104] 内
 *          -231 <= Node.val <= 231 - 1
 *
 *   这道题目没有真正明白！需要多做几遍。
 *
 */
public class Leetcode98 {
    class Solution {

        private boolean valid = true;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return valid;
            dfs(root);
            return valid;
        }

        /**
         * 获取二叉树的最大值和最小值
         * @param root
         * @return
         */
        private int[] dfs(TreeNode root) {
//            if (root == null) return
            // 初始化当前二叉树中的最小值和最大值
            int min = root.val;
            int max = root.val;

            // 当前节点的左子树不为空
            if (root.left != null) {
                // 获取左子树中的最大值和最小值
                int[] res = dfs(root.left);
                // 剪枝
                if (valid == false) return null;
                // 获取左子树中最大值
                int leftTreeMax = res[1];
                // 获取左子树中最小值
                int leftTreeMin = res[0];
                // 如果左子树中的最大值不小于父节点的值，就不满足题意，valid设为false，提前返回。
                if (leftTreeMax >= root.val) {
                    valid = false;
                    return null;
                }
                // 更新二叉树中最小值
                min = leftTreeMin;
            }
            // 当前节点的右子树不为空
            if (root.right != null) {
                // 获取右子树中的最大值和最小值
                int[] res = dfs(root.right);
                // 减枝
                if (valid == false) return null;
                // 获取右子树中的最小值
                int rightTreeMin = res[0];
                // 获取右子树中的最大值
                int rightTreeMax = res[1];
                // 右子树中的最小值不大于当前节点的值，不满足题意，直接返回。
                if (rightTreeMin <= root.val) {
                    valid = false;
                    return null;
                }
                // 更新二叉树中最大值
                max = rightTreeMax;
            }
            // 返回当前二叉树中的最小值与最大值
            return new int[]{min, max};
        }

    }
}
