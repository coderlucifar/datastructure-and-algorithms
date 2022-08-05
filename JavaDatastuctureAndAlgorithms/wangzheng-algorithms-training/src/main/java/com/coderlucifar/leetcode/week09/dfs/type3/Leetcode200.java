package com.coderlucifar.leetcode.week09.dfs.type3;

/**
 * leetcode200: 岛屿数量（中等）
 *      题目描述：
 *          给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *          岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *          此外，你可以假设该网格的四条边均被水包围。
 *
 *      提示：
 *          m == grid.length
 *          n == grid[i].length
 *          1 <= m, n <= 300
 *          grid[i][j] 的值为 '0' 或 '1'
 *
 */
public class Leetcode200 {

    /**
     * 解题思路：
     *  循环二维数组，找到 值等于 '1'的点为入口，深度优先遍历，走过的地点全部标记为已访问，
     *  每进行一次深度优先遍历，就走完一块陆地，用count值记录，
     *  直到把二维数组遍历完毕，count的值就是陆地的数量。
     */
    class Solution {

        private boolean[][] visited;
        private int count = 0;
        public int numIslands(char[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return this.count;
        }

        private void dfs(char[][] grid, int x, int y) {
            int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
            for (int i = 0; i < directions.length; i++) {
                int r = directions[i][0];
                int c = directions[i][1];
                if ((x+r < 0) || (x+r >= grid.length) || (y+c < 0) || (y+c >= grid[0].length)) continue;
                else if (visited[x+r][y+c]) continue;
                else if (grid[x+r][y+c] == '0') continue;
                else {
                    visited[x+r][y+c] = true;
                    dfs(grid, x+r, y+c);
                }
            }
            return;
        }

    }
}
