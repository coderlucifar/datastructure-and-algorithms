package com.coderlucifar.algorithms.dynamic_programming.knapsack;

public class KnapsackSolution {

    /**
     *
     * @param weight 数组中存储每个物品的重量
     * @param n n个物品，n个决策阶段，每个物品放或不放
     * @param w 背包最大容量 ? 做到第 n 个决策时，所有可达的状态记为 true，dp[i][j] 表示第i个决策阶段重量为j的状态是否可达
     * @return 能装物品总和最大值
     */
    public int knapsack(int[] weight, int n, int w) {
        // 记录每个阶段可达的所有状态， 可达就是 true， 不可达就是false，初始化都是false，动态规划的过程就是把可达的状态记录为true的过程
        boolean[][] dp = new boolean[n][w+1];
        // 填第一个状态
        dp[0][0] = true;

        if (weight[0] <= w) {
            dp[0][weight[0]] = true;
        }

        // 第一种填法
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j <= w; j++) {
//                if (dp[i-1][j] == true) {
//                    // 如果前一个阶段重量为j的状态可达，那么当前阶段重量为j的状态必定可达，当前阶段不装物品就行了
//                    dp[i][j] = true;
//                    if (j + weight[i] <= w) {
//                        dp[i][j+weight[i]] = true;
//                    }
//                }
//            }
//        }

        // 状态转移 (填状态转移表的过程) 第二种填法
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w ; j++) {
                if (dp[i-1][j] == true || (j-weight[i] >= 0 && dp[i-1][j-weight[i]] == true)) {
                    // 情况一：如果上一个阶段重量为 j 的状态可达，那么当前阶段重量为 j 的状态必定可达。（当前阶段物品不放）
                    // 情况二：如果上一个阶段重量为 j-weight[i] 的状态可达，那么当前阶段重量为 j 的状态必定可达。（当前阶段物品放入）
//                        j - weight[i] >= 0  上一个阶段的物品重量是非负的！
                    dp[i][j] = true;
                }
            }
        }

        // 输出结果
        for (int i = w; i >= 0; --i) {
            // 从后往前找可达状态，找到的第一个 就是 背包的最大重量。
            if (dp[n-1][i] == true) {
                return i;
            }
        }

        return 0;
    }


}
