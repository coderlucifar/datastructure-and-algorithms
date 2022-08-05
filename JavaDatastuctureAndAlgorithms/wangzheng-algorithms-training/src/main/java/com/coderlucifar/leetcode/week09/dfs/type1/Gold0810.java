package com.coderlucifar.leetcode.week09.dfs.type1;

/**
 *  程序员面试金典08.10: 颜色填充（简单）
 *      题目描述：
 *          编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 *          待填充的图像用二维数组 image 表示，元素为初始颜色值。
 *          初始坐标点的行坐标为 sr 列坐标为 sc。
 *          需要填充的新颜色为 newColor 。
 *         「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 *          请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 *
 *       提示：
 *          image 和image[0]的长度均在范围[1, 50] 内。
 *          初始坐标点 (sr,sc) 满足0 <= sr < image.length 和0 <= sc < image[0].length 。
 *          image[i][j] 和newColor表示的颜色值在范围[0, 65535] 内。
 *
 */
public class Gold0810 {

    /**
     * 题目分析：
     *
     *
     */
    class Solution {

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor == newColor) return image;
            boolean[][] visited = new boolean[image.length][image[0].length];
            visited[sr][sc] =  true;
            image[sr][sc] = newColor;
            backTrack(image, sr, sc, oldColor, newColor, visited);
            return image;
        }

        private void backTrack(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] visited) {
            int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
            for (int i = 0; i < directions.length; i++) {
                int r = directions[i][0];
                int c = directions[i][1];
                // 越界
                if ((sr + r < 0) || (sr + r >= image.length) || (sc + c < 0) || (sc + c >= image[0].length)) continue;
                // 不是周围区域
                if (image[sr+r][sc+c] != oldColor) continue;
                // 访问过
                if (visited[sr+r][sc+c]) continue;
                // 访问
                visited[sr+r][sc+c] = true;
                // 染色
                image[sr+r][sc+c] = newColor;
                backTrack(image, sr+r, sc+c, oldColor, newColor, visited);
                // 没有需要手动恢复的现场
            }
            return;
        }

    }

}
