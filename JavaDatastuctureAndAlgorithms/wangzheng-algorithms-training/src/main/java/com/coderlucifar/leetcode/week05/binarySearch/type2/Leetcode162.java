package com.coderlucifar.leetcode.week05.binarySearch.type2;

/**
 * leetcode162：寻找峰值
 *  峰值元素是指其值严格大于左右相邻值的元素。
 *  给你一个整数数组nums，找到峰值元素并返回其索引。
 *  数组可能包含多个峰值，在这种情况下，返回任何一个峰值 所在位置即可。
 *   你可以假设nums[-1] = nums[n] = -∞ 。
 *   你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *   分析：这道题目的关键在于， 我们可以假设nums[-1] = nums[n] = -∞
 *   也就是说只要一个元素的相邻元素大于它，则在相邻区间内一定存在峰值。
 *   并且即使是单调单调区间也存在峰值，单调区间的峰值就是较大的边界值。
 */
public class Leetcode162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length-1;
            int low = 0;
            int high = n;
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(mid == 0) {
                    low++;
                } else if(mid == n) {
                    high--;
                } else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                    return mid;
                } else if(nums[mid+1] > nums[mid]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            //如果在循环中没有返回结果，说明峰值在边界。
            //比较两个两个边界值，谁大谁就是峰值
            if(nums[0] > nums[n]) {
                return 0;
            } else {
                return n;
            }
        }
    }
}
