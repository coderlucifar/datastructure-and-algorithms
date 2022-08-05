package com.coderlucifar.leetcode.week09.bfs;

import java.util.*;

/**
 * leetcode752：打开转盘锁（中等） BFS
 *      最短路径问题！很不熟练，需要多写几遍！！！
 *
 *      要点：这道题目引出了另一种广度优先遍历 一层一层处理的方法。
 *
 *
 *
 *
 */
public class Leetcode752 {

    class Solution {

        public int openLock(String[] deadends, String target) {
            final String start = "0000";
            // 初始化死亡字典
            Set<String> dead = new HashSet<>();
            for (String deadend : deadends) {
                dead.add(deadend);
            }
            // 边界情况
            if (dead.contains(start)) return -1;
            // 已访问过的结果
            Set<String> visited = new HashSet<>();
            // 借助队列实现BFS
            Queue<String> queue = new LinkedList<>();
            // 初始化
            visited.add(start);
            queue.add(start);
            int depth = 0;
            //
            while (!queue.isEmpty()) {
                // 获取本层的size
                int currentLevelSize = queue.size();
                // 初始化本层已处理的节点数
                int currentLevelDone = 0;
                while (currentLevelDone < currentLevelSize) {
                    String current = queue.poll();
                    currentLevelDone++;
                    if (current.equals(target)) return depth;
                    List<String> nextChoices = generateNext(current, dead, target);
                    for (String choice : nextChoices) {
                        if (visited.contains(choice)) continue;
                        queue.add(choice);
                        visited.add(choice);
                    }
                }
                depth++;
            }
            return -1;
        }

        /**
         * 生成下一转的可选列表。
         * 如果 选择 在死亡列表中，并且与 target 不同就不能加入可选列表。
         */
        private List<String> generateNext(String current, Set<String> dead, String target) {
            List<String> choices = new ArrayList<>();
            char[] currentStr = current.toCharArray();
            for (int i = 0; i < 4; i++) {
                final char ci = currentStr[i];
                final char upDigit = turnUp(ci);
                final char downDigit = turnDown(ci);
                char[] operations = new char[]{upDigit, downDigit};
                for (int j = 0; j < operations.length; j++) {
                    currentStr[i] = operations[j];
                    String str = new String(currentStr);
                    if (!dead.contains(str)) {
                        choices.add(str);
                    }
                }
                currentStr[i] = ci;
            }
            return choices;
        }

        /**
         * 转盘向下转
         */
        private char turnDown(char digit) {
            if (digit != '9') {
                return (char)(digit + 1);
            }
            else {
                return '0';
            }
        }

        /**
         * 转盘向上转
         */
        private char turnUp(char digit) {
            if (digit != '0') {
                return (char) (digit - '1' + 48);
            }
            else {
                return '9';
            }
        }

    }

    public static void main(String[] args) {
        Leetcode752 leetcode752 = new Leetcode752();
        Solution solution = leetcode752.new Solution();

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        int depth = solution.openLock(deadends, target);

        System.out.println(depth);

    }

}
