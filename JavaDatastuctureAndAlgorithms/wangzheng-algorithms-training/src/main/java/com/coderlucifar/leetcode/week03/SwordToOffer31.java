package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * 剑指Offer31. 栈的压入、弹出序列(中等)
 *    输入两个整数序列，第一个序列表示栈的压入顺序请判断第二个序列是否为该栈的弹出顺序。
 *    假设压入栈的所有数字均不相等。
 *    例如，序列{1,2,3,4,5} 是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列
 *    对应的一个弹出序列，但{4,3,5,1,2}就不可能是该压栈序列的弹出序列。
 *
 *    最坏时间复杂度O(n)
 *    平均时间复杂度O(n)
 */
public class SwordToOffer31 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length != popped.length) return false;
            Stack<Integer> stack = new Stack<>();
            int length = popped.length;
            int p = 0;
            for (int i = 0; i < pushed.length; i++) {
                //先入栈
                stack.push(pushed[i]);
                while (!stack.isEmpty()) {
                    //判断是否可以弹出
                    if (stack.peek() == popped[p]) {
                        //如果可以弹出就弹
                        stack.pop();
                        p++;
                    } else {
                        //弹不出就退出当前循环
                        break;
                    }
                }
            }
            if (stack.isEmpty() && p == length) return true;
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
