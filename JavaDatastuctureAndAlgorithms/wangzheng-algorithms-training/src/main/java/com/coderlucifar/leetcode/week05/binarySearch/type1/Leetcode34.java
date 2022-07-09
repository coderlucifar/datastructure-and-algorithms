package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode34：在排序数组中查找元素第一个和最后一个位置
 *      给定一个按照升序排列的整数数组nums，和一个目标值target。
 *      找出给定目标值在数组中的开始位置和结束位置。
 *      如果数组中不存在目标值target, 返回[-1, -1]。
 *      进阶：
 *          你可以设计并实现时间复杂度为O(logn)的算法解决此问题么？
 */
public class Leetcode34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1,-1};
            if(nums.length == 0) return result;
            int low = 0;
            int high = nums.length-1;
            //先找最后一个target的位置，然后再从后往前遍历
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(nums[mid] == target) {
                    if(((mid+1) <= (nums.length-1)) && (nums[mid+1] == target)) {
                        low = mid+1;
                    } else {
                        result[1] = mid;
                        int tmp = mid;
                        while(tmp != -1 && nums[tmp] == target) {
                            tmp--;
                        }
                        result[0] = tmp+1;
                    }
                } else if (nums[mid] < target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return result;
        }
    }
}
