package com.coderlucifar.leetcode.week08.backtracking.hard;

import java.util.ArrayList;
import java.util.List;

/**
 *  程序员面试金典08.02: 八皇后（困难）
 *      题目描述：
 *          设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
 *          这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *          注意：本题相对原题做了扩展
 *
 *
 *         分析：
 *              共有n个决策阶段。
 *              每个决策阶段在当前行的 n列中的一个位置放一个 皇后。
 *              每放一个就检查一下是否合法，不合法就直接回溯。
 *              当 n 个皇后全部放完还没出现不合法的情况，就把结果放入 结果集中
 *
 *
 */
public class Gold0812 {
    class Solution {
        // 阶段(共有n阶段)
        private int stage = 0;

        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 初始化棋盘
            char[][] board = new char[n][n];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = '.';
                }
            }
            // 寻找可行解
            trace(n, board);
            return this.result;
        }

        private void trace(int n, char[][] board) {
            // 得到一个可行的解
            if (stage == n) {
                List<String> answer = new ArrayList<>();
                for (char[] chars : board) {
                    StringBuffer buffer = new StringBuffer();
                    for (char aChar : chars) {
                        buffer.append(aChar);
                    }
                    answer.add(buffer.toString());
                }
                this.result.add(answer);
                return;
            }
            for (int i = 0; i < n; i++) {
                // 当前决策如果无效就跳过
                if (!valid(board, stage, i)) {
                    continue;
                }
                // 决策
                board[stage][i] = 'Q';
                stage++;
                // 进入下一阶段决策
                trace(n, board);
                // 恢复现场，回溯
                stage--;
                board[stage][i] = '.';
            }
            return;
        }

        /**
         * 检查在 (row, col)位置放皇后是否合法
         * @param board
         * @param row
         * @param col
         * @return
         */
        private boolean valid(char[][] board, int row, int col) {
            int p = row - 1;
            // 向上检查
            while (p >= 0) {
                if (board[p][col] == 'Q') {
                    return false;
                }
                p--;
            }
            // 检查左上对角线
            p = row-1;
            int q = col-1;
            while (p >= 0 && q >= 0) {
                if (board[p][q] == 'Q') {
                    return false;
                }
                p--;
                q--;
            }
            // 检查右上对角线
            p = row-1;
            q = col+1;
            while (p >= 0 && q < board.length) {
                if (board[p][q] == 'Q') {
                    return false;
                }
                p--;
                q++;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Gold0812 gold0812 = new Gold0812();
        Solution solution = gold0812.new Solution();
        List<List<String>> solveNQueens = solution.solveNQueens(4);
        for (List<String> solveNQueen : solveNQueens) {
            for (String s : solveNQueen) {
                System.out.println(s);
            }
            System.out.println("--------------------------------");
        }

    }
}
