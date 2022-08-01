package com.coderlucifar.leetcode.week08.backtracking.midium;

import sun.awt.SunGraphicsCallback;

import java.util.*;

/**
 * leetcode40：组合总和II（中等）选出某几个数相加为给定和，有重复数据，只能使用一次，不能有重复答案
 *      题目描述：
 *          给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *          candidates中的每个数字在每个组合中只能使用一次。
 *          注意：解集不能包含重复的组合。
 *
 *      提示:
 *          1 <= candidates.length <= 100
 *          1 <= candidates[i] <= 50
 *          1 <= target <= 30
 *
 *      分析：
 *          1、因为同一个数字不能重复选择，靠游标来控制可选列表的左边界，从而控制下一阶段的可选列表。
 *          2、因为candidates中有重复数字，所以可能产生重复结果，解决方法是，同一决策阶段 选择 val值 不能重复
 *          3、先排序再处理
 *
 */
public class Leetcode40 {
    class Solution {
        // 结果集
        private List<List<Integer>> result = new ArrayList<>();
        // 阶段
        private int count = 0;
        // 路径
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            trace(candidates, 0, target, 0);
            return this.result;
        }

        private void trace(int [] candidates, int start, int target, int curSum) {
            if (start == candidates.length) return;

            // 存储该阶段已经选过的数字
            Set<Integer> usedNumberOfCurrentStage = new HashSet<>();

            for (int i = start; i < candidates.length; i++) {
                if (usedNumberOfCurrentStage.contains(candidates[i])) {
                    continue;
                }
                usedNumberOfCurrentStage.add(candidates[i]);
                path.add(candidates[i]);
                count++;
                if (curSum + candidates[i] == target) {
                    result.add(new ArrayList<>(this.path));
                    count--;
                    path.remove(count);
                    return;
                } else if (curSum + candidates[i] > target) {
                    count--;
                    path.remove(count);
                    return;
                }
                trace(candidates, i+1, target, curSum + candidates[i]);
                count--;
                path.remove(count);
            }
            return;
        }

    }
}
