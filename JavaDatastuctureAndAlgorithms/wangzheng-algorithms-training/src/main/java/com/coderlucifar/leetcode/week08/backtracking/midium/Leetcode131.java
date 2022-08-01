package com.coderlucifar.leetcode.week08.backtracking.midium;

import sun.awt.SunGraphicsCallback;

import java.util.ArrayList;
import java.util.List;

/**
 *  leetcode131：分割回文串（中等）
 *      题目描述：
 *          给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
 *          返回 s 所有可能的分割方案。
 *          回文串 是正着读和反着读都一样的字符串。
 *
 *      提示：
 *          1 <= s.length <= 16
 *          s 仅由小写英文字母组成
 *
 *      分析：
 *          有 n 个字符，就有 n-1 个空。
 *          决策就是 分割/不分割。
 *          共有 n-1 个决策阶段。
 *
 *
 */
public class Leetcode131 {

    class Solution {

        private List<List<String>> result = new ArrayList<>();

        // 阶段
        private int stage = 0;

        private List<Boolean> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            int length = s.length();
            char[] str = s.toCharArray();
            trace(str);
            return this.result;
        }

        private void trace(char[] str) {
            // 所有决策都做完了
            if (this.stage == str.length-1) {
                List<String> answer = new ArrayList<>();
                // 插入所有分割符
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < str.length; i++) {
                    buffer.append(str[i]);
                    if (i < str.length-1 && path.get(i)) {
                        // 需要分割了
                        buffer.append(".");
                    }
                }
                // 分割
                String s = buffer.toString();
                String[] strings = s.split("\\.");
                // 判断该组中的每个字符串是否合法，合法就加入结果，有一个不和法的就不做处理，立马返回
                for (String string : strings) {
                    if (!valid(string)) {
                        return;
                    }
                    answer.add(string);
                }
                this.result.add(answer);
                return;
            }

            boolean[] choice = new boolean[]{true, false};
            for (int i = 0; i < choice.length; i++) {
                path.add(choice[i]);
                stage++;

                trace(str);

                stage--;
                path.remove(stage);
            }

            return;
        }

        /**
         *  验证回文串
         */
        private boolean valid(String str) {
            char[] word = str.toCharArray();
            int i = 0;
            int j = word.length-1;
            while (i < j) {
                if (word[i] == word[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Leetcode131 leetcode131 = new Leetcode131();
        Solution solution = leetcode131.new Solution();
        String s = "aab";
        List<List<String>> partition = solution.partition(s);
        System.out.println("end");
    }

}
