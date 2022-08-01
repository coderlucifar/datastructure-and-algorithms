package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  leetcode78：子集（中等）
 *      题目描述：
 *          给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *          解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *      提示：
 *          1 <= nums.length <= 10
 *          -10 <= nums[i] <= 10
 *          nums中的所有元素互不相同
 */
public class Leetcode78 {
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();
        // 阶段
        private int stage = 0;
        // 路径
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            result.add(new ArrayList<>());
            trace(nums, 0);
            return this.result;
        }

        private void trace(int[] nums, int start) {
            for (int i = start; i < nums.length; i++) {
                path.add(nums[i]);
                result.add(new ArrayList<>(this.path));
                stage++;
                trace(nums, i+1);
                stage--;
                path.remove(stage);
            }
            return;
        }

    }
}
