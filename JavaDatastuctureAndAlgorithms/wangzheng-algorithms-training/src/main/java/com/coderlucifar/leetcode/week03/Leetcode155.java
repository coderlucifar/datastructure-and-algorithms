package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * leetcode155: 最小栈 (简单)
 *      设计一个支持push, pop, top操作，并能在常数时间内检索到最小元素的栈。
 *          push(x) --- 将元素x推入栈中。
 *          pop() --- 删除栈顶的元素。
 *          top() --- 获取栈顶元素。
 *          getMin() --- 检索栈中的最小元素。
 */
public class Leetcode155 {
    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();
        //用一个变量来存储当前栈内的最小元素
        private int minValue = Integer.MAX_VALUE;

        public MinStack() {
        }
        //像栈中push元素的时候看看要不要更新最小值
        public void push(int val) {
            if (val < minValue) minValue = val;
            stack.push(val);
        }
        //弹出栈顶元素之后可能需要更新最小值
        public void pop() {
            if (!stack.isEmpty()) {
                int popValue = stack.pop();
                //如果出栈的值与最小元素相同并且栈非空，那么需要更新最小元素
                if (popValue <= minValue && !stack.isEmpty()) {
                    //先将栈顶元素的值赋给最小元素
                    minValue = stack.peek();
                    //将stack栈中的元素倒腾到tmpStack中，在过程中，更新最小值
                    while (!stack.isEmpty()) {
                        minValue = stack.peek() < minValue ? stack.peek() : minValue;
                        tmpStack.push(stack.pop());
                    }
                    while (!tmpStack.isEmpty()) {
                        stack.push(tmpStack.pop());
                    }
                }
            };
            //只要栈空了，就得把最小值设为最大, 否则会有bug
            if (stack.isEmpty()) {
                this.minValue = Integer.MAX_VALUE;
            }
        }
        //查看栈顶元素
        public int top() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }
        //获取栈中最小元素
        public int getMin() {
            return minValue;
        }
    }

    public static void main(String[] args) {

    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */