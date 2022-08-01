package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode22：括号生成（中等）
 *      题目描述：
 *          数字 n 代表生成括号的对数，请你设计一个函数，
 *          用于能够生成所有可能的并且 有效的 括号组合。
 *
 *      提示： 1 <= n <= 8
 *
 *      解题思路：
 *          1、先生成所有的可能，然后把 无效的括号组合 删除！
 *
 */
public class Leetcode22 {
    class Solution {

        private List<String> result = new ArrayList<>();
        // 当前路径
        private List<Character> path = new ArrayList<>();
        // 决策阶段
        private int count = 0;

        public List<String> generateParenthesis(int n) {
            // 特殊情况处理
            if (n == 1) {
                this.result.add("()");
                return this.result;
            }
            // 下标为0的位置存 '(' 的个数， 下标为1的位置存 ')' 的个数
            int[] brackets = new int[]{n-1, n-1};
            trace(n - 1, brackets);
            return this.result;
        }

        private void trace(int n, int[] brackets) {
            if (this.count == 2*n) {
                StringBuffer buffer = new StringBuffer();
                buffer.append('(');
                for (Character character : path) {
                    buffer.append(character);
                }
                buffer.append(')');
                String s = buffer.toString();
                if (valid(s)) {
                    result.add(s);
                }
                return;
            }

            // 根据情况获取 可选列表
            List<Character> choice = new ArrayList<>();
            if (brackets[0] > 0 && brackets[1] > 0) {
                choice.add('(');
                choice.add(')');
            } else if (brackets[0] > 0 && brackets[1] <= 0) {
                choice.add('(');
            } else if (brackets[0] <= 0 && brackets[1] > 0) {
                choice.add(')');
            }


            for (int i = 0; i < choice.size(); i++) {
                // 当前阶段做决策
                path.add(choice.get(i));
                this.count++;
                char c = choice.get(i);
                if (c == '('){
                    brackets[0]--;
                }else {
                    brackets[1]--;
                }
                // 进入下一阶段
                trace(n, brackets);
                // 回溯
                if (c == '(') {
                    brackets[0]++;
                } else {
                    brackets[1]++;
                }
                this.count--;
                path.remove(this.count);
            }

        }

        /**
         * 检查是否有效
         */
        private boolean valid(String str) {
            char[] chars = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (c == '(') {
                    stack.push(c);
                }
                if (c == ')'){
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
            return true;
        }

    }
}
