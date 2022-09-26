package com.coderlucifar.leetcode.week10.dynamic_programming.knapsack;

/**
 * 目标和
 *      题目描述：
 *          给你一个整数数组 nums 和一个整数 target 。
 *          向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *          例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *          返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *      提示：
 *          1 <= nums.length <= 20
 *          0 <= nums[i] <= 1000
 *          0 <= sum(nums[i]) <= 1000
 *          -1000 <= target <= 1000
 *
 */
public class Leetcode494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // 偏移量
            final int offset = 1000;
            //
            final int w = 2000;
            // dp[i][j] 存截止到第i阶段 状态 为 j出现的次数
            int[][] dp = new int[nums.length][w+1];
            // 初始化
            dp[0][offset+nums[0]] += 1; // 因为 nums[0]可能为0
            dp[0][offset-nums[0]] += 1;
            // 状态转移方程
            for (int i = 1; i <= nums.length-1; i++) {
                for (int j = 0; j <= w; j++) {
                    // 添加 ‘+’
                    if(j - nums[i] >= 0 && j - nums[i] <= w) {
                        dp[i][j] += dp[i-1][j-nums[i]];
                    }
                    // 添加 ‘-’
                    if(j + nums[i] >= 0 && j + nums[i] <= w) {
                        dp[i][j] += dp[i-1][j+nums[i]];
                    }
                }
            }
            return dp[nums.length-1][target+offset];
        }
    }

    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        Solution solution = leetcode494.new Solution();

        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;

        int targetSumWays = solution.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

}
