package com.coderlucifar.leetcode.week05.hashtable.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 程序员面试金典16.21：交换和
 *    题目描述：
 *          给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *          返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 *          若有多个答案，返回任意一个均可。
 *          若无满足条件的数值，返回空数组。
 *    示例：
 *         输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 *         输出: [1, 3]
 *
 *         输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 *         输出: []
 *    提示：
 *         1 <= array1.length, array2.length <= 100000
 *
 */
public class Gold1621 {
    class Solution {
        public int[] findSwapValues(int[] array1, int[] array2) {
            int sum1 = Arrays.stream(array1).sum();
            int sum2 = Arrays.stream(array2).sum();
            int abs = Math.abs(sum1 - sum2);
            if (abs == 0) {
                Set<Integer> set = new HashSet<>();
                for (int i : array1) {
                    set.add(i);
                }
                for (int i = 0; i < array2.length; i++) {
                    if (set.contains(array2[i])) {
                        return new int[]{array2[i],array2[i]};
                    }
                }
                return new int[]{};
            } else if (abs % 2 == 1) {
                //如果两数组元素和的差值是奇数，是不可能通过交换两数组元素满足题意的。
                return new int[]{};
            } else {
                //两数组元素和的差值是偶数
                int target = abs / 2;
                Set<Integer> set = new HashSet<>();
                if (sum1 > sum2) {
                    for (int i : array2) {
                        set.add(i);
                    }
                    for (int i : array1) {
                        if (set.contains(i-target)) {
                            return new int[]{i, i-target};
                        }
                    }
                    return new int[]{};
                } else {
                    for (int i : array1) {
                        set.add(i);
                    }
                    for (int i : array2) {
                        if (set.contains(i-target)) {
                            return new int[]{i-target, i};
                        }
                    }
                    return new int[]{};
                }
            }
        }
    }
}
