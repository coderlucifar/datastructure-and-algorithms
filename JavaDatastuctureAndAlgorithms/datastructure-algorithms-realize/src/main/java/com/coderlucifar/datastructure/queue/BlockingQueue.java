package com.coderlucifar.datastructure.queue;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 阻塞队列
 * @date 2022/8/8 13:18
 */
public interface BlockingQueue <E>{

    boolean add(E e);

    boolean offer(E e);

    E poll();

    E peek();

}
