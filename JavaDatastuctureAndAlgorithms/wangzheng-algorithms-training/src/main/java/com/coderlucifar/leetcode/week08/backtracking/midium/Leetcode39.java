package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.*;

/**
 * leetcode39：组合总和（中等）
 *      题目描述：
 *          给你一个无重复元素的整数数组candidates和一个目标整数target，
 *          找出candidates中可以使数字和为目标数target的所有不同组合 ，并以列表形式返回。
 *          你可以按任意顺序返回这些组合。
 *          candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *          对于给定的输入，保证和为target的不同组合数少于 150 个。
 *
 *      提示：
 *          1 <= candidates.length <= 30
 *          1 <= candidates[i] <= 200
 *          candidate 中的每个元素都 互不相同
 *          1 <= target <= 500
 *
 *     分析：
 *      决策阶段：这道题目的决策阶段不固定，只要 路径和没有大于target就会一直决策。
 *          首先，所有元素都是大于0的，如果当前 路径 已经大于了 target 就没必要进入下一阶段了。
 *          如果当前路径等于了target， 也没必要进入下一阶段了。
 *
 *      如何避免组合的重复？
 *          这道题目的关键在于，后一阶段的决策必须大于等于前一阶段的决策，否则就可能会有重复的组合！！！
 *
 */
public class Leetcode39 {
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();
        // 决策阶段
        private int count = 0;
        // 路径
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // 先给列表排个序
            Arrays.sort(candidates);
            trace(candidates, 0, target, 0);
            return this.result;
        }

        /**
         *
         * @param candidates 可选列表
         * @param curSum 当前路径和
         * @param target
         * @param before 上一次的决策
         */
        private void trace(int[] candidates, int curSum, int target, int before) {

            for (int i = 0; i < candidates.length; i++) {
                // 跳过不能选的数字，获得真正的可选列表起点
                if (candidates[i] < before) {
                    // 为了保证不重复
                    continue;
                }

                // 当前阶段的选择
                path.add(candidates[i]);
                count++;

                // 检查已选路径和是否等于目标值
                if (curSum+candidates[i] == target) {
                    // 结果可能有重复，怎么去重？？？   后一阶段的决策数字 一定要大于前一阶段的决策数字

                    result.add(new ArrayList<>(path));

                    count--;
                    path.remove(count);
                    return;
                } else if (curSum+candidates[i] > target) {
                    // 如果已选路径和大于目标值，就没必要继续决策了
                    count--;
                    path.remove(count);
                    return;
                }

                // 进入下一阶段
                int newBefore = candidates[i];
                trace(candidates, curSum + candidates[i], target, newBefore);
                // 撤销选择！
                count--;
                path.remove(count);
            }
            return;
        }

    }
}
