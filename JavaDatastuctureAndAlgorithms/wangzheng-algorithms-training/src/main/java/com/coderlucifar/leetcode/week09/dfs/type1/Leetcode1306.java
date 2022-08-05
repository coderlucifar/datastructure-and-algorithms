package com.coderlucifar.leetcode.week09.dfs.type1;

/**
 * 跳跃游戏III（中等）
 *
 */
public class Leetcode1306 {
    class Solution {

        private boolean reached = false;

        private boolean[] visited;

        public boolean canReach(int[] arr, int start) {
            visited = new boolean[arr.length];
            visited[start] = true;
            dfs(arr, start);
            return reached;
        }

        private void dfs(int[] graph, int start) {
            if (graph[start] == 0) {
                this.reached = true;
                return;
            }
            int[] directions = new int[]{start-graph[start], start+graph[start]};
            for (int i = 0; i < directions.length; i++) {
                if (directions[i] < 0 || directions[i] >= graph.length) continue;
                else if (visited[directions[i]]) continue;
                else {
                    visited[directions[i]] = true;
                    dfs(graph, directions[i]);
                }
            }
            return;
        }


    }
}
