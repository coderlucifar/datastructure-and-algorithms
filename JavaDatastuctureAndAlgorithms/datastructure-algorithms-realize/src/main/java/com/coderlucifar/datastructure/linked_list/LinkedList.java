package com.coderlucifar.datastructure.linked_list;

/**
 * 实现单链表
 * @param <E> 链表中元素
 */
public class LinkedList<E> implements List<E>{
    // 当前容量
    transient int size = 0;
    // 头指针
    transient Node<E> first;
    // 尾指针
    transient Node<E> last;

    public LinkedList(){};

    /**
     * step2.5
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * step2.4
     * @param e
     * @return
     */
    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    /**
     * step2.3
     * @param e
     * @return
     */
    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    /**
     * step2.1: 头插
     * @param e
     */
    void linkFirst(E e) {
        // 保存当前头节点
        final Node<E> head = this.first;
        // 创建一个新节点，插入到头节点前
        final Node<E> newNode = new Node<>(null, e, head);
        // 头指针指向新节点
        this.first = newNode;
        // 如果之前没有头节点，将尾指针指向新节点
        if (head == null) {
            this.last = newNode;
        }
        // 如果之前有头节点，将它的前驱指针指向新节点
        else {
            head.prev = newNode;
        }
        // 链表元素个数增加
        size++;
    }

    /**
     * step2.2: 尾插
     * @param e
     */
    void linkLast(E e) {
        final Node<E> tail = last;
        final Node<E> newNode = new Node<>(tail, e, null);
        last = newNode;
        if (tail == null) {
            first = newNode;
        }
        else {
            tail.next = newNode;
        }
        size++;
    }

    /**
     * step3.1
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for(Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * step3.2
     * 拆链
     * @param x 要拆的节点
     * @return
     */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    /**
     * step4.2
     * 获取下标为index的节点值
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).item;
    }

    /**
     * step4.1
     * 获取下标为index的节点
     * 链表中的节点的虚拟下标我们约定从0开始，也就是 index = 3，那么就是第四个节点
     * @param index
     * @return
     */
    Node<E> node(int index) {
        // 如果查找的元素在链表的左半部分，从前往后找
        if (index < (size >> 1)) {
            Node<E> x = first;
            for(int i = 0; i < index; i++)
                x = x.next;
            return x;
        }
        // 如果查找的元素在链表的右半部分
        else {
            Node<E> x = last;
            for (int i = size-1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void printLinkList() {
        Node<E> x = first;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }

    /**
     * step1：定义链表节点
     * @param <E> 节点中存储的元素类型
     */
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
