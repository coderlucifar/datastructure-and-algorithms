package com.coderlucifar.leetcode.week09.dfs.type1;

/**
 * 剑指offer13：机器人的运动范围（中等）
 *      题目描述：
 *          地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 *          一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 *          也不能进入行坐标和列坐标的数位之和大于k的格子。
 *          例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 *          但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *      提示：
 *          1 <= n,m <= 100
 *          0 <= k <= 20
 *
 */
public class SwordToOffer13 {
    /**
     *  题目分析：
     *
     *
     */
    class Solution {
        // 统计到达的格子个数，在起点时相当于已经到达一个格子
        private int count = 1;
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            visited[0][0] = true;
            backTrack(m, n, k, visited, 0, 0);
            return this.count;
        }

        private void backTrack(int m, int n, int k, boolean[][] visited, int curRow, int curCol) {

            // 可选列表(左，上，右，下四个方向)
            int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
            for (int i = 0; i < directions.length; i++) {
                int row = directions[i][0];
                int col = directions[i][1];
                // 越界不能走
                if ((curRow + row > m-1) || (curRow + row < 0) || (curCol + col > n-1) || (curCol + col < 0)) continue;
                // 数位和大于k不能走
                if (!valid(curRow+row, curCol+col, k)) continue;
                // 访问过不能走
                if (visited[curRow+row][curCol+col]) continue;
                // 走一步
                count++;
                // 已访问
                visited[curRow+row][curCol+col] = true;
                backTrack(m, n, k, visited, curRow+row, curCol+col);
                // 没有需要手动恢复现场的变量，不做后续处理！
            }
            return;
        }

        /**
         * 行列数位和是否小于等于 k 即为可选。
         */
        private boolean valid(int row, int column, int k) {
            String rowValue = String.valueOf(row);
            String columnValue = String.valueOf(column);
            String str = rowValue + columnValue;
            char[] digits = str.toCharArray();
            int sum = 0;
            for (char digit : digits) {
                sum += (digit - 48);
            }
            if (sum > k) return false;
            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println('0' - 48);
        System.out.println('1' - 48);
        System.out.println('2' - 48);
        System.out.println('3' - 48);
        System.out.println('4' - 48);
        System.out.println('5' - 48);
        System.out.println('6' - 48);
        System.out.println('7' - 48);
        System.out.println('8' - 48);
        System.out.println('9' - 48);
    }

}
