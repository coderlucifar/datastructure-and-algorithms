package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode704：二分查找
 *  给定一个n个元素有序的（升序）整型数组nums和一个目标值target, 写一个函数搜索nums中的target,
 *  如果目标值存在返回下标，否则返回-1。
 *
 */
public class Leetcode704 {
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length-1, target);
        }

        private int binarySearch(int[] nums, int l, int r , int target) {
            while (l <= r) {
                int mid = l + (r-l)/2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    l = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -1;
        }
    }
}
