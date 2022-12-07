package com.coderlucifar.datastructure.heap;

import java.util.Arrays;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 堆
 * @date 2022/11/6 20:46
 */
public class Heap <E> implements IHeap<E> {

    // 默认初始化大小
    private final static int DEFAULT_INITIAL_CAPACITY = 11;
    // 容器
    transient Object[] queue;
    // 容器内元素个数
    private int size = 0;

    public Heap() {
        this.queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        // 非空校验
        if (e == null) {
            throw new NullPointerException();
        }

        // 判断是否需要扩容
        int i = size;
        if (i >= queue.length) {
            grow(i + 1);
        }

        size = i + 1;
        // 如果添加的是第一个元素，直接添加
        if (i == 0) {
            queue[0] = e;
        }
        // 添加的如果不是第一个元素，需要自下而上的堆化
        else {
            siftUp(i, e);   // 为什么是i而不是i+1，因为下标从0开始！
        }

        return true;
    }

    /**
     * 自下而上堆化
     * @param n
     * @param e
     */
    private void siftUp(int n, E e) {
        siftUpComparable(n, e);
    }

    private void siftUpComparable(int n, E e) {

    }


    /**
     * 扩容方法
     * @param minCapacity 需要的最小容量
     */
    private void grow(int minCapacity) {
        // 获取旧的容量
        int oldCapacity = queue.length;
        // 获取新容量
        int newCapacity = oldCapacity + ((oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1));
        // 溢出判断修正
        if (newCapacity - Integer.MAX_VALUE - 8 > 0) {
            newCapacity = (oldCapacity > Integer.MAX_VALUE - 8) ? Integer.MAX_VALUE : Integer.MAX_VALUE - 8;
        }
        // 转移元素
        queue = Arrays.copyOf(queue, newCapacity);
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

}
