package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * leetcode20: 有效的括号 （简单）
 *      给定一个只包括 '(', ')', '{', '}', '[' , ']' 的字符串s ，
 *      判断字符串是否有效。
 * 有效字符串需满足:
 *      1.左括号必须用相同类型的右括号闭合。
 *      2.左括号必须以正确的顺序闭合。
 *
 */
public class Leetcode20 {
    class Solution {
        private Stack<Character> stack = new Stack<>();

        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            //如果字符数组为空，或者字符个数是奇数个，则直接判定为无效字符串
            if (chars.length % 2 == 1 || chars.length == 0) return false;
            // 如果字符个数是偶数个
            for (char c : chars) {
                //如果栈是空的，就入栈
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    //查看当前栈顶元素
                    Character top = stack.peek();
                    //判断是否可以消
                    boolean remove = remove(top, c);
                    if (remove) {
                        //可以消就出栈
                        stack.pop();
                    } else {
                        //不能消就入栈
                        stack.push(c);
                    }
                }
            }
            //循环过后，如果栈为空贼为有效字符串
            if (stack.isEmpty()) return true;
            return false;
        }

        /**
         * 判断c1和c2是否可以抵消
         * @param c1
         * @param c2
         * @return
         */
        private boolean remove(char c1, char c2) {
            if (c1 == '(' && c2 == ')') return true;
            if (c1 == '{' && c2 == '}') return true;
            if (c1 == '[' && c2 == ']') return true;
            return false;
        }

    }

    public static void main(String[] args) {
        String s = "({[)";
        Leetcode20 leetcode20 = new Leetcode20();
        Solution solution = leetcode20.new Solution();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }
}
