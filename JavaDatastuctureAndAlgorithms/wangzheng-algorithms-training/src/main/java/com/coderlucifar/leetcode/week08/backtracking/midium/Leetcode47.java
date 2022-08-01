package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.*;

/**
 *  leetcode47：全排列II（中等）有重复数据
 *      题目描述：给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *      提示：
 *          1 <= nums.length <= 8
 *          -10 <= nums[i] <= 10
 *
 *      分析：如何避免重复
 *          同一个下标的数字，在一条路径中只能被使用一次。通过控制可选列表实现
 *          同一个决策阶段，值为val的数字只能使用一次。
 *
 */
public class Leetcode47 {
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();
        // 阶段
        private int count = 0;
        // 路径
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            // 相当于可选列表里可以选的值
            Map<Integer, Integer> numberCount = new HashMap<>();
            // 初始化可选列表里可以选的值
            for (int i : nums) {
                numberCount.put(i, numberCount.getOrDefault(i, 0) + 1);
            }
            trace(nums, numberCount);
            return this.result;
        }

        /**
         *
         * @param nums 可选列表
         * @param numberCount 可选列表里真正可以选的值
         */
        private void trace(int[] nums, Map<Integer, Integer> numberCount) {
            // 当前路径所有决策做完
            if (this.count == nums.length) {
                this.result.add(new ArrayList<>(this.path));
                return;
            }
            // 当前阶段使用过的数字
            Set<Integer> usedNumberOfCurrentStage = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (numberCount.get(nums[i]) <= 0) {
                    // 数字已经被别的阶段用了
                    continue;
                }
                if (usedNumberOfCurrentStage.contains(nums[i])){
                    // 这个阶段已经用过这个数字了，同一个决策阶段，值为val的数字只能使用一次。
                    continue;
                }
                usedNumberOfCurrentStage.add(nums[i]);
                // 本阶段决策
                this.path.add(nums[i]);
                numberCount.put(nums[i], numberCount.get(nums[i])-1);
                count++;
                // 进入下一阶段
                trace(nums, numberCount);
                // 撤销选择，回溯
                count--;
                this.path.remove(count);
                numberCount.put(nums[i], numberCount.get(nums[i])+1);
            }
            return;
        }

    }
}
