package com.coderlucifar.leetcode.week09.dfs.type3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 程序员面试金典16.19: 水域大小（中等）
 *      题目描述：
 *          你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 *          若值为0则表示水域。
 *          由垂直、水平或对角连接的水域为池塘。
 *          池塘的大小是指相连接的水域的个数。
 *          编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 *      提示：
 *          0 < len(land) <= 1000
 *          0 < len(land[i]) <= 1000
 *
 */
public class Gold1619 {
    class Solution {
        private boolean[][] visited;

        private List<Integer> result = new ArrayList<>();

        private int count;
        public int[] pondSizes(int[][] land) {
            visited = new boolean[land.length][land[0].length];
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (!visited[i][j] && land[i][j] == 0) {
                        count = 1;
                        visited[i][j] = true;
                        dfs(land, i, j);
                        int c = this.count;
                        result.add(c);
                    }
                }
            }
            result.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            int[] res = new int[result.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.result.get(i);
            }
            return res;
        }

        private void dfs(int[][] land, int x, int y) {
            int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
            for (int i = 0; i < directions.length; i++) {
                int r = directions[i][0];
                int c = directions[i][1];
                if ((x+r < 0) || (x+r >= land.length) || (y+c < 0) || (y+c >= land[0].length)) continue;
                else if (visited[x+r][y+c]) continue;
                else if (land[x+r][y+c] != 0) continue;
                else {
                    visited[x+r][y+c] = true;
                    this.count++;
                    dfs(land, x+r, y+c);
                }
            }
            return;
        }


    }
}
