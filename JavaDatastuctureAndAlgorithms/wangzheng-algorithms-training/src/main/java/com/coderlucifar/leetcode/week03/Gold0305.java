package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * 程序员面试金典 03.05. 栈排序 （中等）
 *      栈排序。编写程序，对栈进行排序使最小元素位于栈顶。
 *      最多只能使用一个其他的临时栈存放数据，但不得将元素复制到
 *      别的数据结构(如数组)中。该栈支持如下操作：push、pop、peek和isEmpty。
 *      当栈为空时，peek返回-1。
 */
public class Gold0305 {
    class SortedStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();

        public SortedStack() {

        }
        //入栈,始终要保持从栈顶到栈底，元素从小到大排列。 类似插入排序！！！
        public void push(int val) {
            //当栈非空，并且当前栈顶元素比要插入的元素小时
            while (!stack.isEmpty() && stack.peek() < val) {
                //当前栈顶元素放入临时栈
                tmpStack.push(stack.pop());
            }
            //放入待插入元素
            stack.push(val);
            //将临时栈的元素再转移回原栈
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
        }
        //出栈
        public void pop() {
            if (!stack.isEmpty())
            stack.pop();
        }
        //查看栈顶元素
        public int peek() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
