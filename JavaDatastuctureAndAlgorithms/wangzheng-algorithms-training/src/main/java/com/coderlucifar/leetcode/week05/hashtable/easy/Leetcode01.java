package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode01:  两数之和
 */
public class Leetcode01 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap();
            for(int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for(int j = 0; j < nums.length; j++) {
                if(map.containsKey(target-nums[j])) {
                    if(map.get(target-nums[j]) != j) {
                        return new int[]{j,map.get(target-nums[j])};
                    }
                }
            }
            return new int[]{};
        }
    }
}
