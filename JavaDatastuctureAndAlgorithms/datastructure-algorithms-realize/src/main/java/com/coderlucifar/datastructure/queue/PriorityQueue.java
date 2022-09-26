package com.coderlucifar.datastructure.queue;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 优先级队列
 * @date 2022/8/8 13:21
 */
public class PriorityQueue<E> implements Queue<E>{

    private final static int DEFAULT_INITIAL_CAPACITY = 11;

//    private transient Object[] queue;
    transient Object[] queue;

    private int size = 0;

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }


}
