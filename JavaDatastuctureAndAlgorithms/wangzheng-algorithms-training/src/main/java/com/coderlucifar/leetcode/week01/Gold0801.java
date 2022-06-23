package com.coderlucifar.leetcode.week01;

import java.util.*;

/**
 * 面试题01.08. 零矩阵：
 *      编写一种算法，若M x N矩阵中某个元素为0，则将其所在的行与列
 */
public class Gold0801 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            //先遍历一遍，把是0的位置都记录下来
            //最大行数
            int rowMax = matrix.length;
            int columnMax = matrix[0].length;
            Map<Integer,Boolean> rowHaveZeroMap = new HashMap<>();
            Map<Integer,Boolean> columnHaveZeroMap = new HashMap<>();

            //遍历行
            for (int i = 0; i < rowMax; i++) {
                //遍历列
                for (int j = 0; j < columnMax; j++) {
                    if (matrix[i][j] == 0) {
                        rowHaveZeroMap.put(i, true);
                        columnHaveZeroMap.put(j, true);
                    }
                }
            }

            //循环结束后，两个Map中记录了有0的行数，和列数
            //遍历行
            for (int i = 0; i < rowMax; i++) {
                //遍历列
                for (int j = 0; j < columnMax; j++) {
                    if (columnHaveZeroMap.containsKey(j) || rowHaveZeroMap.containsKey(i)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] a = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] b = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        Gold0801 gold0801 = new Gold0801();
        Solution solution = gold0801.new Solution();
        solution.setZeroes(b);

        for (int[] ints : b) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
