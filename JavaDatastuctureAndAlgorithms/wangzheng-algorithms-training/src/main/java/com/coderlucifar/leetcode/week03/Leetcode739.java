package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * 每日温度(中等) 单调栈
 *      请根据每日气温列表temperatures, 请计算在每一天需要等几天才会有更高的温度。
 *      如果气温在这之后都不会升高，请在该位置用0来代替。
 *
 *    重点要理解单调栈理存的单调是什么单调。
 */
public class Leetcode739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            int[] result = new int[length];
            //单调栈
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int idx = stack.peek();
                    result[idx] = i - idx;
                    stack.pop();
                }
                stack.push(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
