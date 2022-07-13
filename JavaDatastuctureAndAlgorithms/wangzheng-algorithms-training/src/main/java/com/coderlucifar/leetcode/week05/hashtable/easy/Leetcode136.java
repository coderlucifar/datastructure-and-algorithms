package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode136: 只出现一次的数字
 *      解法：这道题上来直观的感觉可以使用哈希表破解，但是空间复杂度较高，不符合题意。
 *      但是这个章节我们就是要练习哈希表，所以我们使用哈希表破解。
 *
 *      到了位运算章节，我们会专门使用位运算破解一遍。
 */
public class Leetcode136 {
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                } else {
                    set.add(nums[i]);
                }
            }
            List<Integer> collect = set.stream().collect(Collectors.toList());
            return collect.get(0);
        }
    }
}
