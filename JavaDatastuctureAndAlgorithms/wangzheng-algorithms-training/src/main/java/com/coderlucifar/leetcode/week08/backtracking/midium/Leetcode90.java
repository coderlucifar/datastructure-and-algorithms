package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.*;

/**
 *  leetcode90：子集II（中等）有重复数据
 *      题目描述：
 *          给你一个整数数组nums，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *          解集 不能 包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 *
 *      提示：
 *         1 <= nums.length <= 10
 *         -10 <= nums[i] <= 10
 *
 *      分析： 怎么保证不重复？
 *          同一个阶段不可以选 val相同的数字。
 *          每个下标位置的数字 在一条路径中不能多次使用。
 *
 */
public class Leetcode90 {

    class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        private int stage = 0;

        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> canUse = new HashMap<>();
            for (int num : nums) {
                canUse.put(num, canUse.getOrDefault(num, 0) + 1);
            }
            this.result.add(new ArrayList<>());
            trace(nums, 0, canUse);
            return this.result;
        }

        private void trace(int[] nums, int start, Map<Integer, Integer> canUse) {
            Set<Integer> usedNumberOfCurrentStage = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (canUse.get(nums[i]) <= 0) {
                    continue;
                }
                if (usedNumberOfCurrentStage.contains(nums[i])) {
                    continue;
                }
                usedNumberOfCurrentStage.add(nums[i]);
                path.add(nums[i]);
                result.add(new ArrayList<>(this.path));
                stage++;
                canUse.put(nums[i], canUse.get(nums[i])-1);

                trace(nums, i+1, canUse);

                stage--;
                path.remove(stage);
                canUse.put(nums[i], canUse.get(nums[i])+1);
            }
            return;
        }

    }

}
