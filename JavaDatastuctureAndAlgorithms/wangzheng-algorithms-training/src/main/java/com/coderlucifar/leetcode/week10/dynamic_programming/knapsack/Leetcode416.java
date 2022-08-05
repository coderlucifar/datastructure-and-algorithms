package com.coderlucifar.leetcode.week10.dynamic_programming.knapsack;

/**
 * 分割等和子集 （coderlucifar初入动态规划之门）
 *      题目描述：
 *          给你一个只包含正整数的非空数组 nums 。
 *          请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *      提示：
 *          1 <= nums.length <= 200
 *          1 <= nums[i] <= 100
 *
 */
public class Leetcode416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            // 求数组所有元素和
            for (int num : nums) {
                sum += num;
            }
            // 如果和为奇数，那么就不可能分为两个等和子集
            if (sum % 2 == 1) return false;
            // 求和的一半
            final int halfSum = sum / 2;
            // 接下来就可以抽象为 0,1 背包问题
            // 数组中的每个数就是一个物品，是否存在 n 个物品的和恰好为 halfSum
            // 即是否存在 第 n个 阶段和 为 halfSum的状态！
            boolean[][] dp = new boolean[nums.length][halfSum+1];
            // 初始化
            dp[0][0] = true;
            if (nums[0] < halfSum) {
                dp[0][nums[0]] = true;
            }

            // 状态转移方程
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= halfSum ; j++) {
                    if (dp[i-1][j] == true || (j-nums[i] >= 0 && dp[i-1][j-nums[i]] == true)) {
                        dp[i][j] = true;
                        // 如果中途在某个阶段达到 halfSum 状态，直接退出
                        if (j == halfSum) return true;
                    }
                }
            }
            // 检查是否有解
            for (int i = 0; i < dp.length; i++) {
                if (dp[i][halfSum]) {
                    return true;
                }
            }
            return false;
        }
    }
}
