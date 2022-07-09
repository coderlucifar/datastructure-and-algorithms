package com.coderlucifar.leetcode.week04.sort;

/**
 * 剑指Offer21: 调整数组顺序使奇数位于偶数前面(简单)：
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *      使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *  提示：
 *      0 <= nums.length <= 50000
 *      0 <= nums[i] <= 10000
 *
 */
public class SwordToOffer21 {
    class Solution {
        public int[] exchange(int[] nums) {
            if (nums.length <= 1) return nums;
            //初始化奇数区间
            int i = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % 2 != 0) {
                    swap(nums,i+1,j);
                    i++;
                } else {
                    continue;
                }
            }
            return nums;
        }

        private void swap(int[] num, int l, int r) {
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
        }
    }
}
