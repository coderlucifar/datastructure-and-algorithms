package com.coderlucifar.leetcode.week05.binarySearch.type2;

/**
 * leetcode852： 山脉数组的峰值索引
 *
 * 说明：注意边界条件的处理方法！！！
 *
 */
public class Leetcode852{
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int low = 0;
            int high = arr.length-1;
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(mid == 0) {
                    low = mid+1;
                } else if(mid == arr.length-1) {
                    high = mid-1;
                } else if((arr[mid-1] < arr[mid]) && (arr[mid+1] < arr[mid])) {
                    return mid;
                } else if((arr[mid-1] < arr[mid]) && (arr[mid+1] > arr[mid])) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return -1;
        }
    }
}
