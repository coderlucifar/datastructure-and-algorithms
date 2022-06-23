package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * leetcode1047: 删除字符串中的所有相邻重复项 (简单)
 *      给出由小写字母组成的字符串s，
 *      重复项删除操作会选择两个相邻且相同的字母，
 *      并删除它们。
 *      在S上反复执行重复项删除操作，直到无法继续删除。
 *      在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 */
public class Leetcode1047 {
    class Solution {

        private Stack<Character> stack = new Stack<>();

        public String removeDuplicates(String s) {
            if (s == null) return null;
            if ("".equals(s)) return "";
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char top = stack.peek();
                    if (top == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) return "";
            int size = stack.size();
            char[] result = new char[size];
            while (size > 0) {
                result[size-1] = stack.pop();
                size--;
            }
            return new String(result);
        }
    }

    public static void main(String[] args) {

    }
}
