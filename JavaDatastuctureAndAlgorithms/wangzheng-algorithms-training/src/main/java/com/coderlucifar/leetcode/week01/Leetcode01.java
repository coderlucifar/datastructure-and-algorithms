package com.coderlucifar.leetcode.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode第一题：两数之和。
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案
 */
public class Leetcode01 {

        class Solution {
            public int[] twoSum(int[] nums, int target) {
                //首先建立一个以nums数组值为key，数组值为value的字典
                Map<Integer,Integer> map = new HashMap();
                //建立字典
                for(int i = 0; i < nums.length; i++) {
                    map.put(nums[i], i);
                }
                //寻找可能结果
                for(int i = 0; i < nums.length; i++) {
                    //target和当前元素的差值
                    int differ = target - nums[i];
                    //检查差值在不在字典中
                    if (map.containsKey(differ)) {
                        int res = map.get(differ);
                        if (res != i) {
                            return new int[]{i, res};
                        }
                    }
                }
                return null;
            }
        }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        Leetcode01 practice01 = new Leetcode01();
        Solution solution = practice01.new Solution();
        int[] res = solution.twoSum(nums, target);
        if (res.length > 0) {
            System.out.print("[");
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1)
                    System.out.print(res[i] + ",");
                else
                    System.out.print(res[i]);
            }
            System.out.print("]");
        }
    }

}
