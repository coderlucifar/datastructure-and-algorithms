package com.coderlucifar.leetcode.week01;

/**
 * 程序员面试金典：面试题16.04.井字游戏(中等)
 */
public class Gold1604 {
    class Solution {
        public String tictactoe(String[] board) {
            //获取NxN棋盘每行的格子数
            final int N = board[0].toCharArray().length;
            //创建一个棋盘
            char[][] boards = new char[N][N];
            //填充棋盘
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    boards[i][j] = (board[i].toCharArray())[j];
                }
            }

            //判断是否有获胜玩家

            //循环判断每行每列
            for (int i = 0; i < N; i++) {
                //如果该行所有字符相等
                if (allSame(board[i].toCharArray())) {
                    //如果这个相等的字符不为空，返回胜者
                    if (board[i].toCharArray()[0] != ' ') return board[i].toCharArray()[0] + "";
                }

                //如果该列所有字符相等
                char[] columnChars = getColumn(boards, i, N);
                //如果该列所有字符相等
                if (allSame(columnChars)) {
                    //如果该列的相等字符不为空，返回胜者
                    if (columnChars[0] != ' ') return columnChars[0] + "";
                }
            }

            //判断正对角线
            char[] diagonal = getDiagonal(boards, N);
            if (allSame(diagonal)) {
                if (diagonal[0] != ' ') return diagonal[0] + "";
            }
            //判断反对角线
            char[] reverseDiagonal = getReverseDiagonal(boards, N);
            if (allSame(reverseDiagonal)) {
                if (reverseDiagonal[0] != ' ') return reverseDiagonal[0] + "";
            }

            //判断是否平局
            if (!haveEmpty(boards, N)) return "Draw";

            //如果不是上面两种情况，则游戏继续进行
            return "Pending";
        }

        /**
         * 判断一个字符数组的每个字符是否都相等
         * @param chars
         * @return
         */
        private boolean allSame(char[] chars) {
            int c = chars[0];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != c) return false;
            }
            return true;
        }

        /**
         * 获取二维数组的第n列
         * 列数从0开始
         * @param n 列 从0开始
         * @return
         */
        private char[] getColumn(char[][] chars,final int n, final int length){
            char[] result = new char[length];
            for (int i = 0; i < length; i++) {
                result[i] = chars[i][n];
            }
            return result;
        }

        /**
         * 获取二维数组的正对角线
         * @param chars
         * @return
         */
        private char[] getDiagonal(char[][] chars, final int length) {
            char[] result = new char[length];
            for (int i = 0; i < length; i++) {
                result[i] = chars[i][i];
            }
            return result;
        }

        /**
         * 获取二维数组的反对角线
         * @param chars
         * @return
         */
        private char[] getReverseDiagonal(char[][] chars, final int length) {
            char[] result = new char[length];
            for (int i = 0, j = length - 1; i < length; i++,j--) {
                result[i] = chars[j][i];
            }
            return result;
        }

        /**
         * 判断二维数组中是否存在空位 ' '
         * @param boards
         * @return
         */
        private boolean haveEmpty(char[][] boards, final int length) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (boards[i][j] == ' ') return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Gold1604 gold1604 = new Gold1604();
        Solution solution = gold1604.new Solution();
        String[] board1 = new String[]{"O X"," XO","X O"};
        String[] board2 = new String[]{"OOX","XXO","OXO"};
        String[] board3 = new String[]{"OOX","XXO","OX "};
        String tictactoe = solution.tictactoe(board3);
        System.out.println(tictactoe);

    }
}
