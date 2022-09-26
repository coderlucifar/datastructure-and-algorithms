package com.coderlucifar.datastructure.queue;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 单端队列
 * @date 2022/8/8 13:16
 */
public interface Queue <E>{

    boolean add(E e);

    boolean offer(E e);

    E poll();

    E peek();

}
