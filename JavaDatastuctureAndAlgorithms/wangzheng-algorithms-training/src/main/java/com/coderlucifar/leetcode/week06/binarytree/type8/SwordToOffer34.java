package com.coderlucifar.leetcode.week06.binarytree.type8;

import java.util.ArrayList;
import java.util.List;

/**
 *  剑指offer34：二叉树中和为某一值的路径 (中等)
 *      题目描述：给你二叉树的根节点root和一个整数目标和targetSum ，
 *              找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *              叶子节点是指没有子节点的节点。
 *      提示：
 *          树中节点总数在范围 [0, 5000] 内
 *          -1000 <= Node.val <= 1000
 *          -1000 <= targetSum <= 1000
 *
 */
public class SwordToOffer34 {

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
        private List<List<Integer>> res = new ArrayList<>();
        private List<TreeNode> path = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) return this.res;
            dfs(root, target, 0);
            return this.res;
        }

        private void dfs(TreeNode root, int target, int currentSum) {
            if (root == null) {
                return;
            }

            currentSum = currentSum + root.val;
            this.path.add(root);
            if (currentSum == target && root.left == null && root.right == null) {
                // 到达叶子节点，并且当前路径和等于目标值，说明得到一组满足要求的解！
                addRes();   // 将当前满足要求的解添加到结果解中
            }

            // 做下阶段决策
            if (root.left != null) {
                dfs(root.left, target, currentSum);
            }
            if (root.right != null) {
                dfs(root.right, target, currentSum);
            }

            // 回溯
            this.path.remove(root);
            return;
        }

        private void addRes() {
            List<Integer> targets = new ArrayList<>();
            if (this.path.size() > 0) {
                for (TreeNode treeNode : this.path) {
                    targets.add(treeNode.val);
                }
                this.res.add(targets);
            }
        }

    }

    public static void main(String[] args) {

    }

}
