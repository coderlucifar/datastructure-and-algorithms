package com.coderlucifar.leetcode.week09.dfs.type4;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode207：课程表 (拓扑排序问题)
 *      拓扑排序问题通常有两种方式解决，使用Khan算法或者DFS算法。
 *
 *
 */
public class Leetcode207 {
    class SolutionByKahn {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 建模，将图用邻接表表示
            List<Integer>[] adj = new List[numCourses];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new ArrayList<>();
            }
            // 构造临接表的同时，统计每个顶点的入度
            int[] inDegree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
                inDegree[prerequisites[i][0]]++;
            }
            // 扫描入度数组，找到入度为0的顶点存进 zeroInDegree
            List<Integer> zeroInDegree = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    zeroInDegree.add(i);
                }
            }
            int finished = 0;
            while (!zeroInDegree.isEmpty()) {
                finished++;
                int vertex = zeroInDegree.remove(zeroInDegree.size() - 1);
                for (Integer i : adj[vertex]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        zeroInDegree.add(i);
                    }
                }
            }
            return finished == numCourses;
        }
    }

    class SolutionByDFS {


    }

}
