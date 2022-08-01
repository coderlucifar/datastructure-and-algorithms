package com.coderlucifar.leetcode.week05.hashtable.medium;

import java.util.*;

/**
 *  leetcode15: 三数之和（中等）
 *      题目描述：
 *          给你一个包含 n 个整数的数组nums，
 *          判断nums中是否存在三个元素 a，b，c ，
 *          使得 a + b + c = 0 ？
 *          请你找出所有和为 0 且不重复的三元组。
 *      注意：答案中不可以包含重复的三元组。
 *
 *      示例 1：
 *      输入：nums = [-1,0,1,2,-1,-4]
 *      输出：[[-1,-1,2],[-1,0,1]]
 *
 *      示例 2：
 *      输入：nums = []
 *      输出：[]
 *
 *      示例 3：
 *      输入：nums = [0]
 *      输出：[]
 *
 *      提示：
 *          0 <= nums.length <= 3000
 *          -10^5 <= nums[i] <= 10^5
 *
 *
 *      解法一：排序加哈希表
 *      解法二：排序加双指针
 *
 *      问题：为啥这道题可以用双指针，但是两数之和不能用双指针。
 */
public class Leetcode15 {

    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner("-");
        stringJoiner.add("a");
        stringJoiner.add("a");
        stringJoiner.add("a");
        System.out.println(stringJoiner);
        String s = stringJoiner.toString();
        System.out.println(s);
    }

    class Solution {

        /**
         * 先排序，在使用哈希表
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum_improve01(int[] nums) {
            if (nums.length < 3) return new ArrayList<>();
            List<List<Integer>> resList = new ArrayList<>();
            //给数组中所有元素排序，为了方便给结果去重
            Arrays.sort(nums);
            // 建立字典，key为 数组中的元素值，value为数组下标
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            // 遍历寻找所有可能的结果
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i-1]) {
                    // 避免第一个位置元素重复
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j != i+1 && nums[j] == nums[j-1]) {
                        // 避免第二个位置元素重复
                        continue;
                    }
                    int target = 0-nums[i]-nums[j];
                    if (map.containsKey(target) && map.get(target) > j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(target);
                        resList.add(list);
                    }
                }
            }
            return resList;
        }

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return new ArrayList<>();
            List<List<Integer>> resList = new ArrayList<>();
            // 建立字典，key为 数组中的元素值，value为数组下标
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            //
            Set<String> usedResultSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int target = 0-nums[i]-nums[j];
                    if (map.containsKey(target) && map.get(target) > j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(target);
                        list.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1-o2;
                            }
                        });
                        StringJoiner stringJoiner = new StringJoiner("-");
                        list.forEach(r -> stringJoiner.add(String.valueOf(r)));
                        if (!usedResultSet.contains(stringJoiner.toString())) {
                            resList.add(list);
                            usedResultSet.add(stringJoiner.toString());
                        }
                    }
                }
            }
            return resList;
        }
    }
}
