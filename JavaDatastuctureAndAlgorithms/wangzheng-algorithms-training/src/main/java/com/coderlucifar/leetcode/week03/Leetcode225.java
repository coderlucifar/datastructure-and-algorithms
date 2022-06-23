package com.coderlucifar.leetcode.week03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode225：用队列实现栈 (简单)
 *      请你仅使用两个队列实现一个后入先出（LIFO）的栈，
 *      并支持普通队列的全部四种操作(push、top、pop和empty)
 *      实现MyStack类：
 *          void push(int x)将元素x压入栈顶。
 *          int pop()移除并返回栈顶元素。
 *          int top() 返回栈顶元素。
 *          boolean empty() 如果栈是空的，返回true；否则，返回false。
 *
 *      注意：
 *          你只能使用队列的基本操作 -- 也就是push to back、peek/pop from front、size和
 *          is empty这些操作。
 *
 *          你所使用的语言也许不支持队列。你可以使用list或者deque来模拟一个队列，
 *          只要是标准的队列操作即可。
 */
public class Leetcode225 {
    class MyStack {
        //使用链表实现的双端队列
        private Queue<Integer> queue = new LinkedList<>();
        //构造方法
        public MyStack() {

        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            int maxSize = queue.size();
            for (int i = 0; i < maxSize - 1; i++) {
                queue.offer(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            int maxSize = queue.size();
            for (int i = 0; i < maxSize - 1; i++) {
                queue.offer(queue.poll());
            }
            int result = queue.peek();
            queue.offer(queue.poll());
            return result;
        }

        public boolean empty() {
            return queue.size() > 0 ? false : true;
        }
    }

    public static void main(String[] args) {

    }
}
