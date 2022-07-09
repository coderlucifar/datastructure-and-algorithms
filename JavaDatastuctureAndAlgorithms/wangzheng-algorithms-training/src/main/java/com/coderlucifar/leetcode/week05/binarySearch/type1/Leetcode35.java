package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode35：搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回索引。
 *  如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  你可以假设数组中无重复元素。
 */
public class Leetcode35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            //特殊情况处理
            if(target < nums[0]) return 0;
            if(target > nums[nums.length-1]) return nums.length;
            int low = 0;
            int high = nums.length-1;
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] > target) {
                    if(nums[mid-1] < target) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
