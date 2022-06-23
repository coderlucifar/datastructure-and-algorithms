package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * 程序员面试金典16.26. 计算器 (中等)
 *      给定一个包含正整数、加(+)、 减(-)、 乘(*)、 除(/)的算数表达式(括号除外),
 *      计算其结果。
 *      表达式仅包含非负整数, +, -, *, / 四种运算符和空格 。
 *      整数除法仅保留整数部分。
 */
public class Gold1626 {
    class Solution {
        public int calculate(String s) {
            char[] chars = s.toCharArray();
            //字符数组长度
            int length = chars.length;
            //保存计算结果
            int result = 0;
            //数字栈
            Stack<Integer> numberStack = new Stack<>();
            //符号栈
            Stack<Character> symbolStack = new Stack<>();
            //用来表示有没有计算过
            boolean flag = false;
            for (int i = 0; i < length; i++) {
                //跳过空格
                if (' ' == chars[i]) {
                    continue;
                }
                //如果是数字字符就一直遍历计算
                while (isInt(chars[i])) {
                    flag = true;
                    result = result * 10 + (chars[i]-'0');
                    i++;
                    if (i >= length) break;
                }
                //将计算后的结果加入数字栈
                if (flag) {
                    //数字入栈
                    numberStack.push(result);
                    flag = false;
                    result = 0;
                    i--;
                    continue;
                }
                //如果是符号
                if (isSymbol(chars[i])){
                    //如果符号栈为空，直接入栈
                    if (symbolStack.isEmpty()) {
                        symbolStack.push(chars[i]);
                    }
                    //如果符号栈不为空
                    else {
                        while (!symbolStack.isEmpty() && prior(symbolStack.peek(), chars[i])) {
                            //符号栈顶元素的优先级 大于 当前符号的优先级
                            int v2 = numberStack.pop();
                            int v1 = numberStack.pop();
                            char c = symbolStack.pop();
                            int cal = cal(v1, v2, c);
                            numberStack.push(cal);
                        }
                        if (symbolStack.isEmpty() || !prior(symbolStack.peek(), chars[i])){
                            symbolStack.push(chars[i]);
                        }
                    }
                    continue;
                }
            }
            while (numberStack.size() > 1) {
                int v2 = numberStack.pop();
                int v1 = numberStack.pop();
                char c = symbolStack.pop();
                int cal = cal(v1, v2, c);
                numberStack.push(cal);
            }
            if (numberStack.size() == 1) result = numberStack.pop();
            return result;
        }

        private boolean isSymbol(char c) {
            if (c == '*') return true;
            if (c == '/') return true;
            if (c == '+') return true;
            if (c == '-') return true;
            return false;
        }

        /**
         * 判断是否为0-9之间的整数
         * @param c
         * @return
         */
        private boolean isInt(char c) {
            int i = c - '0';
            if (i >= 0 && i <= 9) return true;
            return false;
        }

        /**
         * 比较符号  c1 和 c2的优先级
         * 如果c1的优先级大于等于c2就返回true
         * @param c1
         * @param c2
         * @return
         */
        private boolean prior(char c1, char c2) {
            if (c1 == '*' || c1 == '/') return true;
            if ((c1 == '+' || c1 == '-') && (c2 == '+' || c2 == '-')) return true;
            return false;
        }

        /**
         * 计算根据传入的两个数和计算符号做计算
         * @param v1
         * @param v2
         * @param c
         * @return
         */
        private int cal(int v1, int v2, char c) {
            if (c == '+') return v1 + v2;
            else if (c == '-') return v1 - v2;
            else if (c == '*') return v1*v2;
            else return v1/v2;
        }

    }

    public static void main(String[] args) {
        Gold1626 gold1626 = new Gold1626();
        Solution solution = gold1626.new Solution();
        String s1 = "3+2*2";
        String s2 = " 3/2 ";
        String s3 = " 3+5 / 2";
        String s4 = "2048";
        String s5 = "0";
        String s6 = "1*2-3/4+5*6-7*8+9/10";
        int calculate = solution.calculate(s6);
        System.out.println(calculate);
    }
}
