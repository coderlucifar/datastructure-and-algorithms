package com.coderlucifar.leetcode.week06.binarytree.type8;

/**
 * leetcode124：二叉树中的最大路径和 (困难)
 *      路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 *      同一个节点在一条路径序列中 至多出现一次 。
 *      该路径 至少包含一个 节点，且不一定经过根节点。
 *
 *      路径和 是路径中各节点值的总和。
 *      给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 */
public class Leetcode124 {
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

    /**
     *  在求解某一问题的过程中记录 路径和，不断更新这个路径和，最后的路径和就是最大值！！！
     *  现在问题的关键就是，找出这个需要求解的问题！需要对题目提出的问题做一个转换！
     *
     *  什么问题可以分解为子问题，并且求解的过程中可以求路径和。
     */
    class Solution {
        private int maxPath = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            calculateMaxPathSumByRootEnd(root);
            return this.maxPath;
        }

        /**
         * 以根节点为上顶点的最大路径和
         */
        private int calculateMaxPathSumByRootEnd(TreeNode root) {
            if (root == null) return 0;
            // 当前节点值
            int val = root.val;
            // 以左子树根节点为上顶点的最大路径和
            int leftChildTreeRootMaxPathSum = calculateMaxPathSumByRootEnd(root.left);
            // 以右子树根节点为上顶点的最大路径和
            int rightChildTreeRootMaxPathSum = calculateMaxPathSumByRootEnd(root.right);

//            if (val + leftChildTreeRootMaxPathSum + rightChildTreeRootMaxPathSum > this.maxPath) {
//                this.maxPath = val + leftChildTreeRootMaxPathSum + rightChildTreeRootMaxPathSum;
//            }
            int newMax = val;
            if (leftChildTreeRootMaxPathSum > 0 && rightChildTreeRootMaxPathSum > 0) {
                newMax = newMax + leftChildTreeRootMaxPathSum + rightChildTreeRootMaxPathSum;
            } else if (leftChildTreeRootMaxPathSum > 0) {
                newMax = newMax + leftChildTreeRootMaxPathSum;
            } else if (rightChildTreeRootMaxPathSum > 0) {
                newMax = newMax + rightChildTreeRootMaxPathSum;
            }
            if (newMax > this.maxPath) this.maxPath = newMax;


            int max = Math.max(leftChildTreeRootMaxPathSum, rightChildTreeRootMaxPathSum);
            if (max > 0) {
                val = val + max;
            }
            return val;
        }
    }

    public static void main(String[] args) {
        Leetcode124 leetcode124 = new Leetcode124();
        Solution solution = leetcode124.new Solution();
        // 构造参数
        TreeNode root = new Leetcode124().new TreeNode(2);
        TreeNode leftChild = new Leetcode124().new TreeNode(-1);
        root.left = leftChild;
        solution.maxPathSum(root);
    }

}
