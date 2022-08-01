package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.*;

/**
 * leetcode349: 两个数组的交集
 *
 *  进阶：k个数组求交集。
 */
public class Leetcode349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) return new int[]{};
            Set<Integer> set = new HashSet<>();
            for (int i : nums1) {
                set.add(i);
            }
            Set<Integer> resultSet = new HashSet<>();
            for (int i : nums2) {
                if (set.contains(i)) {
                    resultSet.add(i);
                }
            }
            if (resultSet.size() <= 0) return new int[]{};
            int[] res = new int[resultSet.size()];
            Iterator<Integer> iterator = resultSet.iterator();
            int k = 0;
            while (iterator.hasNext()) {
                int next = iterator.next();
                res[k++] = next;
            }
            return res;
        }
    }
}
