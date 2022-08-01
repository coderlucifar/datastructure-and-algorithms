package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指offer：数组中重复的数字
 */
public class SwordToOffer03 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                } else {
                    return nums[i];
                }
            }
            return -1;
        }
    }
}
