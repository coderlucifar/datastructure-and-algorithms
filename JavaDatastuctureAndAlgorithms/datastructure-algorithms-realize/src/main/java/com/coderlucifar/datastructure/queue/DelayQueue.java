package com.coderlucifar.datastructure.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 延迟队列
 * @date 2022/8/8 13:26
 */
public class DelayQueue<E extends Delayed> implements BlockingQueue<E>{

    // 优先级队列
    private final PriorityQueue<E> q = new PriorityQueue();

    // 可重入锁
    private final transient ReentrantLock lock = new ReentrantLock();

    // 信号量
    private final Condition available = lock.newCondition();

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
