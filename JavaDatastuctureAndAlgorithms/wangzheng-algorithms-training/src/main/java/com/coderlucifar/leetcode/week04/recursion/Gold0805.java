package com.coderlucifar.leetcode.week04.recursion;

/**
 * 递归乘法:
 *      写一个递归函数，不使用 * 运算符，实现两个正整数的相乘。可以使用
 *      加号、减号、位移，但要吝啬一些。
 *
 *      提示：
 *          1、保证乘法范围不会溢出
 */
public class Gold0805 {
    class Solution {
        public int multiply(int A, int B) {
            if (A == 0 || B == 0) return 0;
            return multiplyAB(A, B);
        }

        private int multiplyAB(int A, int B) {
            int min = Math.min(A, B);
            int max = Math.max(A, B);
            //递归终止条件
            if (min == 1) return max;

            //将原问题分解为规模更小的子问题   //
            int halfValue = multiplyAB(min >> 1, max);

            //利用子问题的解求解原问题
            if (min % 2 == 0) {
                return halfValue + halfValue;
            } else {
                return halfValue + halfValue + max;
            }
        }
    }
}
