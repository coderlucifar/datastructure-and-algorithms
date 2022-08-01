package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.ArrayList;
import java.util.List;

/**
 *  leetcode77：组合(中等)
 *      题目描述：
 *          给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *          你可以按 任何顺序 返回答案。
 *      提示：
 *          1 <= n <= 20
 *          1 <= k <= n
 */
public class Leetcode77 {

    class Solution {

        private List<List<Integer>> result = new ArrayList<>();
        // 阶段
        private int stage = 0;
        // 路径
        private List<Integer> path = new ArrayList<>();

        /**
         *
         * @param n 可选列表
         * @param k k个阶段
         * @return
         */
        public List<List<Integer>> combine(int n, int k) {
            trace(n, 1, k);
            return this.result;
        }

        private void trace(int n, int start, int k) {
            if (this.stage == k) {
                result.add(new ArrayList<>(this.path));
                return;
            }
            for (int i = start; i <= n; i++) {
                path.add(i);
                stage++;
                trace(n, i+1, k);
                stage--;
                path.remove(stage);
            }
            return;
        }

    }

}
