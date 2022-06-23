package com.coderlucifar.leetcode.week01;

/**
 * leetcode240题：搜索一个二维矩阵II(中等)
 *      编写一个高效的算法来搜索 m x n 矩阵 matrix中的一个目标值 target。
 *      该矩阵具有以下特性：
 *          每行的元素从左到右生序排列。
 *          每列的元素从上到下生序排列。
 */
public class leetcode240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //行数
            int m = matrix.length;
            //列数
            int n = matrix[0].length;

            //行指针位置
            int i = 0;
            //列指针位置
            int j = n - 1;

            while (i <= m-1 && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                }

                if (matrix[i][j] < target ) {
                    i++;
                    continue;
                }

                if (matrix[i][j] > target) {
                    j--;
                    continue;
                }
            }
            return false;

        }
    }

    public static void main(String[] args) {

    }
}
