package com.coderlucifar.datastructure.linked_list;

/**
 * 链表的顶级接口
 * @param <E> 链表中存储的元素类型
 */
public interface List<E> {

    /**
     * 添加元素的默认实现，用户不需要纠结选择头插法还是尾插法
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 头插法
     * @param e
     * @return
     */
    boolean addFirst(E e);

    /**
     * 尾插法
     * @param e
     * @return
     */
    boolean addLast(E e);

    /**
     * 删除元素
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 获取下标为index的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 打印链表
     */
    void printLinkList();

}
