package com.coderlucifar.leetcode.week06.binarytree.type8;

import java.util.HashMap;
import java.util.Map;

/**
 *  路径总和III（中等）
 *      题目描述：
 *          给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *          路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *      提示：
 *          二叉树的节点个数的范围是 [0,1000]
 *          -10^9 <= Node.val <= 10^9
 *          -1000 <= targetSum <= 1000
 *
 *      方法一： 深度优先搜索
 *      方法二：前缀和 + 回溯
 *
 */
public class Leetcode437 {
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
     * 递归 + 前缀和 + 回溯
     */
    class Solution2 {

        // 前缀和map
        Map<Long, Integer> prefix = new HashMap<>();

        private int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            prefix.put(0L, 1);  // 一个节点都没有时，前缀和为0的有1个
            dfs(root, targetSum, 0);
            return this.res;
        }

        private void dfs(TreeNode root, int targetSum, long curSum) {
            if (root == null) return;
            curSum += root.val;
            if (prefix.containsKey(curSum - targetSum) && prefix.get(curSum - targetSum) > 0) {
                this.res += prefix.get(curSum - targetSum);
            }
            prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);

            dfs(root.left, targetSum, curSum);
            dfs(root.right, targetSum, curSum);

            prefix.put(curSum, prefix.getOrDefault(curSum, 1) - 1);
            return;
        }

    }

    /**
     * 双递归的解法
     */
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            // 求以当前节点为起点的路径数（逻辑太多封装成一个方法了）
            int rootSum = rootSum(root, (long)targetSum);

            // 求左子树里 路径和为targetSum的路径数目
            int pathSumOfLeftChild = pathSum(root.left, targetSum);
            // 求右子树里 路径和为targetSum的路径数目
            int pathSumOfRightChild = pathSum(root.right, targetSum);
            // 用子问题的解构造原问题的解
            return rootSum + pathSumOfLeftChild + pathSumOfRightChild;
        }

        /**
         * 原问题：从root出发，路径和为targetSum的路径数量
         * 子问题：从root的子节点出发，路径和为 targetSum - root.val 的路径数量
         */
        private int rootSum(TreeNode root, long targetSum) {
            if (root == null) return 0;
            int ret = 0;
            if (root.val == targetSum) {
                ret++;
            }
            ret += rootSum(root.left, targetSum - root.val);
            ret += rootSum(root.right, targetSum - root.val);
            return ret;
        }

    }

    /**
     * 官方题解一：
     *      分析：
     *          原问题：以root为根节点的树的符合条件的路径和
     *          子问题：1、以root的左子树根节点为根的树符合条件的路径和
     *                 2、以root的右子树根节点为根的树符合条件的路径和
     *   官方题解有个小错，在计算过程中可能造成溢出，你能找到在哪嘛？
     */
    class OfficialSolutionOne {
            public int pathSum(TreeNode root, int targetSum) {
                if (root == null) {
                    return 0;
                }

                int ret = rootSum(root, targetSum);
                ret += pathSum(root.left, targetSum);
                ret += pathSum(root.right, targetSum);
                return ret;
            }

            public int rootSum(TreeNode root, int targetSum) {
                int ret = 0;

                if (root == null) {
                    return 0;
                }

                int val = root.val;
                if (val == targetSum) {
                    ret++;
                }

                ret += rootSum(root.left, targetSum - val);
                ret += rootSum(root.right, targetSum - val);

                return ret;
            }

    }

    /**
     * 官方题解二：使用前缀和 + 回溯的思想
     */
    class OfficialSolutionTwo {
        // key：前缀和 value：出现次数
        private Map<Long, Integer> prefix = new HashMap<>();
        // 满足条件的路径数量
        private int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            // 前缀和为0的路径只有一条：哪个节点都不选
            prefix.put(0L, 1);
            // 深度优先遍历
            dfs(root, targetSum, 0);
            return this.res;
        }

        /**
         * 大体思路是深度优先遍历DFS，但是这里我们用的是前序遍历。
         * 为啥用前序遍历？
         *      首先，因为前序遍历的过程是，先处理当前节点，也就是执行当前阶段的处理逻辑（计算以当前节点为终点的前缀和，检查当前前缀和与目标值的差值是否存在于已经保存的前缀和哈希表中）。
         *      其次，左右递归的过程可以理解为做决策的过程，做完决策也就进入了下一阶段。
         *
         *
         *
         * 回溯是怎么体现的：
         *      可选列表：[左递归，右递归]。
         *      决策：左递归or右递归。
         *      当前路径：存在prefix中。  这个路径是一个抽象的概念，在这道题目中，路径就是当前prefix中保存的所有前缀和
         *
         * 思考：利用回溯来解决问题，是否需要首先抽象出三要素。
         */
        private void dfs(TreeNode root, int targetSum, long curSum) {
            if (root == null) return;
            // 计算以当前节点为终点的前缀和
            curSum = curSum + root.val;
            // 如果前缀和map中包含值为 当前前缀和-路径和 的子前缀和，并且该子前缀和的数量大于0
            if (prefix.containsKey(curSum - targetSum) && prefix.get(curSum - targetSum) > 0) {
                // 更新目标路径和的个数
                this.res += prefix.get(curSum - targetSum);
            }
            // 将当前节点加入路径
            prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);

            // 2、当前阶段的决策
            // 在其左子树中递归寻找
            dfs(root.left, targetSum, curSum);
            // 在其右子树中递归寻找
            dfs(root.right, targetSum, curSum);


            // 3、撤销选择
            // 在归之前，将当前节点从路径中拿出
            prefix.put(curSum, prefix.getOrDefault(curSum, 1) - 1);
            return;
        }

    }

    public static void main(String[] args) {

    }

}
