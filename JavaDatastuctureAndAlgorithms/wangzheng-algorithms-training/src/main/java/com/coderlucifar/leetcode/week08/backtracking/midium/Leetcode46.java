package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.*;

/**
 * leetcode46：全排列（中等）
 *      题目描述：
 *          给定一个 不含重复数字 的数组 nums ，返回其 所有可能的全排列 。
 *          你可以 按任意顺序 返回答案。
 *
 *      提示：
 *          1 <= nums.length <= 6
 *          -10 <= nums[i] <= 10
 *          nums 中的所有整数 互不相同
 */
public class Leetcode46 {
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        // 路径
        private List<Integer> path = new ArrayList<>();
        // 阶段
        private int count = 0;
        // 当前路径中已存在的数字
        private Set<Integer> used = new HashSet<>();

        public List<List<Integer>> permute(int[] nums) {
            Arrays.sort(nums);
            trace(nums);
            return this.result;
        }

        private void trace(int[] nums) {
            if (count == nums.length) {
                result.add(new ArrayList<>(this.path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!used.contains(nums[i])) {
                    path.add(nums[i]);
                    count++;
                    used.add(nums[i]);
                } else {
                    continue;
                }
                trace(nums);
                count--;
                path.remove(count);
                used.remove(nums[i]);
            }
            return;
        }

    }
}
