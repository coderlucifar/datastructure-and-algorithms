package com.coderlucifar.leetcode.week03;

/**
 * 程序员面试金典03.01.三合一 (简单)
 *      三合一。描述如何只用一个数组来实现三个栈。
 *      你应该实现push(stackNum, value) 、 pop(stackNum)
 *              isEmpty(stackNum) 、 peek(stackNum) 方法。
 *      说明：stackNum表示栈下标，value表示压入的值。
 *      构造函数会传入一个stackSize函数，代表每个栈的大小。  //从题意可以看出每个栈的大小一样
 *
 *      0 <= stackNum <= 2
 */
public class Gold0301 {
    class TripleInOne {
        private int[] array;
        //保存每个栈中当前的元素个数
        private int[] sizes;
        //保存当前栈顶元素下标
        private int[] tops;
        //保存每个栈的最大元素个数
        private final int maxSize;

        public TripleInOne(int stackSize) {
            this.maxSize = stackSize;
            //初始化数组大小
            array = new int[3*stackSize];
            //初始化每个栈的元素个数
            sizes = new int[] {0,0,0};
            //初始化每个栈的栈顶元素坐标
            tops = new int[] {0,stackSize,2*stackSize};
        }

        /**
         *
         * @param stackNum 第几个栈（第stackNum个栈）
         * @param value
         */
        public void push(int stackNum, int value) {
            //当前栈未满
            if (sizes[stackNum] < maxSize) {
                //当前栈不为空
                if (sizes[stackNum] > 0) {
                    //获取当前栈顶下标
                    int top = tops[stackNum];
                    // 栈顶指针后移
                    top = top + 1;
                    //入栈
                    array[top] = value;
                    //更新当前栈的栈顶下标
                    tops[stackNum] = top;
                    //更新当前栈的元素个数
                    sizes[stackNum]++;
                }
                //当前栈为空，则栈顶元素坐标不用更新
                else {
                    //获取当前栈顶下标
                    int top = tops[stackNum];
                    //入栈
                    array[top] = value;
                    //更新当前栈的元素个数
                    sizes[stackNum]++;
                }
            }
        }

        /**
         * 弹出第 n 个栈的栈顶元素
         * @param stackNum
         * @return
         */
        public int pop(int stackNum) {
            //获取这个栈的当前元素个数
            int currentSize = sizes[stackNum];
            int result = -1;
            //如果栈中有元素
            if (currentSize > 0) {
                if (currentSize > 1) {
                    //获取栈顶下标
                    int index = tops[stackNum];
                    //获取栈顶元素值
                    result = array[index];
                    //出栈操作
                    //当前栈的元素个数减1
                    sizes[stackNum]--;
                    //更新当前栈的栈顶元素下标
                    tops[stackNum]--;
                }
                else {
                    //获取栈顶下标
                    int index = tops[stackNum];
                    //获取栈顶元素值
                    result = array[index];
                    //出栈操作
                    //当前栈的元素个数减1
                    sizes[stackNum]--;
                }
            }
            return result;
        }

        public int peek(int stackNum) {
            int result = -1;
            //获取这个栈的当前元素个数
            int currentSize = sizes[stackNum];
            //如果栈中有元素
            if (currentSize > 0) {
                //获取栈顶下标
                int index = tops[stackNum];
                //获取栈顶元素值
                result = array[index];
            }
            return result;
        }

        public boolean isEmpty(int stackNum) {
            if (sizes[stackNum] <= 0) return true;
            return false;
        }
    }

    public static void main(String[] args) {

    }
/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
}
