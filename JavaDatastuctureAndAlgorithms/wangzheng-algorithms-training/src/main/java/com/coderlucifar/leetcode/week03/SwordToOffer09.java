package com.coderlucifar.leetcode.week03;

import java.util.Stack;

/**
 * 剑指Offer09. 用两个栈实现队列 （简单）
 *      用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead,
 *      分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回-1)
 *
 * 解决思路：两个栈倒腾。
 *
 */
public class SwordToOffer09 {

}

class CQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmpStack = new Stack<>();

    public CQueue() {}

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        int result = -1;
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            tmpStack.push(temp);
        }
        Integer pop = tmpStack.pop();
        if (pop != null) {
            result = pop;
        }
        while (!tmpStack.isEmpty()) {
            Integer temp = tmpStack.pop();
            stack.push(temp);
        }
        return result;
    }
}
