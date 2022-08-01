package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode17：电话号码的字母组合(中等)
 *      题目描述：
 *          给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 *          答案可以按 任意顺序 返回。
 *          给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class Leetcode17 {
    class Solution {


        private List<String> result = new ArrayList<>();

        // 第n阶段
        private int count = 0;

        // 以选路径
        private List<Character> path = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || "".equals(digits)) return new ArrayList<String>();
            char[] digit = digits.toCharArray();
            trace(digit);
            return this.result;
        }

        private void trace(char[] digit) {
            if (this.count == digit.length) {
                if (path.size() > 0) {
                    StringBuffer buffer = new StringBuffer();
                    for (Character character : path) {
                        buffer.append(character);
                    }
                    result.add(buffer.toString());
                }
                return;
            }

            char c = digit[count];
            // 可选列表
            List<Character> alpha = getAlpha(c);
            for (int i = 0; i < alpha.size(); i++) {
                this.path.add(alpha.get(i));
                this.count++;
                trace(digit);
//                this.path.remove(alpha.get(i));
//                this.count--;
                this.count--;
                this.path.remove(this.count);
            }
            return;
        }

        private List<Character> getAlpha(char digit) {
            if (digit == '2') return Arrays.asList('a','b','c');
            else if (digit == '3') return Arrays.asList('d','e','f');
            else if (digit == '4') return Arrays.asList('g','h','i');
            else if (digit == '5') return Arrays.asList('j','k','l');
            else if (digit == '6') return Arrays.asList('m','n','o');
            else if (digit == '7') return Arrays.asList('p','q','r','s');
            else if (digit == '8') return Arrays.asList('t','u','v');
            else if (digit == '9') return Arrays.asList('w','x','y','z');
            else return null;
        }

    }

    public static void main(String[] args) {
        List<Character> list = Arrays.asList('a', 'b', 'c');
        StringBuffer buffer = new StringBuffer();
        for (Character character : list) {
            buffer.append(character);
            System.out.println(character);
        }
        String s = buffer.toString();
        System.out.println(s);
    }
}
