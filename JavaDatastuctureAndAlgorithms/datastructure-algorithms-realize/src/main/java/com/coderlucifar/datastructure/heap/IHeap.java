package com.coderlucifar.datastructure.heap;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 堆接口
 * @date 2022/11/5 20:30
 */
public interface IHeap<E> {

    /**
     * 添加元素入堆
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 添加元素入堆
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 查看堆顶元素
     * @return
     */
    E peek();

    /**
     * 堆定元素出堆
     * @return
     */
    E poll();


}
