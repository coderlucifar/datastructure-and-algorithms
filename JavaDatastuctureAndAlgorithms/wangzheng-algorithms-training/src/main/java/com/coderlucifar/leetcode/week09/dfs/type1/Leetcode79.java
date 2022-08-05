package com.coderlucifar.leetcode.week09.dfs.type1;

/**
 * leetcode79: 单词搜索（中等）
 *      题目描述：
 *          给定一个 m x n 二维字符网格board 和一个字符串单词word 。
 *          如果word 存在于网格中，返回 true ；否则，返回 false 。
 *          单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 *          同一个单元格内的字母不允许被重复使用。
 *
 *      提示：
 *          m == board.length
 *          n = board[i].length
 *          1 <= m, n <= 6
 *          1 <= word.length <= 15
 *          board 和 word 仅由大小写英文字母组成
 *
 */
public class Leetcode79 {
    /**
     * 解题思路：
     *      1、先扫描二维数组记录所有可能的起点
     *      2、从起点出发走路，每走一步要看看是不是我们需要的 字符 如果不是就continue，是就跳到下一层决策。
     *      3、等决策次数到达单词长度，相当于就找到了一个解，返回true，减枝！
     */
    class Solution {

        private boolean[][] visited;

        private boolean found;

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            char[] alphas = word.toCharArray();
            char firstAlpha = alphas[0];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == firstAlpha) {
                        visited = new boolean[m][n];
                        visited[i][j] = true;
                        backTrack(board, i, j, m, n, alphas, 1);
                        if (found) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private void backTrack(char[][] board, int curRow, int curCol, int m, int n, char[] alphas, int p) {
            if (p == alphas.length) {
                this.found = true;
                return;
            }
            int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for (int i = 0; i < directions.length; i++) {
                int r = directions[i][0];
                int c = directions[i][1];
                if ((curRow+r < 0) || (curRow+r >= m) || (curCol+c < 0) || (curCol+c >= n)) {
                    continue;
                }
                if (visited[curRow+r][curCol+c]) {
                    continue;
                }
                if (board[curRow+r][curCol+c] != alphas[p]) {
                    continue;
                }
                visited[curRow+r][curCol+c] = true;
                backTrack(board, curRow+r, curCol+c, m, n, alphas, p+1);

                visited[curRow+r][curCol+c] = false;
            }
            return;
        }


    }
}
