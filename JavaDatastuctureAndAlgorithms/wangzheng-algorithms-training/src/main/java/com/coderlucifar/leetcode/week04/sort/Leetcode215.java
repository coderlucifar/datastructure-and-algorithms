package com.coderlucifar.leetcode.week04.sort;

import java.util.Arrays;

/**
 * leetcode215：数组中的第K个最大元素(中等)
 *      给定整数数组nums和整数k, 请返回数组中第k个最大的元素。
 *      请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 *
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        return quickSort_c(nums, k);
    }

    private int quickSort_c(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if (l > r) return -1;  //注意这个地方不能带等于号
        int partition = partition(nums, l, r);
        if ((r - partition + 1) == k) {
            return nums[partition];
        } else if ((r - partition + 1) > k) {
            return quickSort(nums, partition+1, r, k);
        } else {
            return quickSort(nums, l, partition-1, (k-(r-partition+1)));
        }
    }

    private int partition(int[] nums, int l, int r) {
        int i = l-1;
        for (int j = l; j < r; j++) {
            if (nums[j] < nums[r]) {
                swap(nums, i+1, j);
                i++;
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
