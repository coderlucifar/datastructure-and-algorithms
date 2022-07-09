package com.coderlucifar.leetcode.week04.sort;

import java.util.Arrays;

/**
 * leetcode1502：判断能否形成等差数列(简单):
 *      给定一个数字数组arr。
 *      如果一个数列中，任意相邻两项的差总等于同一个常数，
 *      那么这个数列就称为等差数列。
 *      如果可以重新排列数组形成等差数列，请返回true；
 *      否则，返回false。
 *
 */
public class Leetcode1502 {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr.length < 2) return false;
            Arrays.sort(arr);
            int dec = arr[1] - arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i-1] != dec) return false;
            }
            return true;
        }
    }
}
