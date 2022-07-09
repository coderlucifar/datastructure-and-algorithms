package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode74：搜索二维矩阵
 *
 */
public class Leetcode74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;  // m行
            int n = matrix[0].length;   // n列
            //先确定目标值所在行
            int rowLow = 0;
            int rowHigh = matrix.length-1;
            while(rowLow <= rowHigh) {
                int rowMid = rowLow + (rowHigh-rowLow)/2;
                if(target >= matrix[rowMid][0] && target <= matrix[rowMid][n-1]) {
                    //找到行了
                    int low = 0;
                    int high = n-1;
                    while(low <= high) {
                        int mid = low + (high-low)/2;
                        if(matrix[rowMid][mid] == target) {
                            return true;
                        } else if(matrix[rowMid][mid] > target) {
                            high = mid-1;
                        } else {
                            low = mid+1;
                        }
                    }
                    return false;
                } else if(target < matrix[rowMid][0]) {
                    rowHigh = rowMid-1;
                } else {
                    rowLow = rowMid+1;
                }
            }
            return false;
        }
    }
}
