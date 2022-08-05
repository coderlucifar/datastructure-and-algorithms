package com.coderlucifar.leetcode.week09.dfs.type2;

import java.util.HashSet;

/**
 *  程序员面试金典04.01: 节点间通路（中等）
 *      题目描述：节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 *      提示：
 *          1、节点数量n在[0, 1e5]范围内。
 *          2、节点编号大于等于 0 小于 n。
 *          3、图中可能存在自环和平行边。
 */
public class Gold0401 {
    /**
     * 题目分析：
     *      关键在于 将题目所给的数据结构建模，构造临接表，然后进行深度优先搜索
     */
    class Solution {

        private boolean find = false;

        private HashSet<Integer>[] adj;

        private boolean[] visited;

        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            if (start >= n || target >= n || n == 0) return false;
            if (start == target) return true;
            adj = new HashSet[n];
            visited = new boolean[n];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new HashSet<>();
            }
            for (int i = 0; i < graph.length; i++) {
                adj[graph[i][0]].add(graph[i][1]);
            }
            visited[start] = true;
            dfs(adj, start, target);
            return this.find;
        }

        private void dfs(HashSet<Integer>[] adj, int start, int target) {
            if (start == target) this.find = true;
            for (int next : adj[start]) {
                if (visited[next]) continue;
                visited[next] = true;
                dfs(adj, next, target);
            }
            return;
        }

    }

}
