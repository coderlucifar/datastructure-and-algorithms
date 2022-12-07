package com.coderlucifar.datastructure.array_list;

import java.util.Arrays;

public class ArrayList<E> implements List<E>{

    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 集合元素数量
     */
    private int size = 0;
    /**
     * 空元素
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};
    /**
     * 元素数组缓存区(ArrayList底层用数组存储元素)
     */
    transient Object[] elementData;

    public ArrayList(){
        // 初始化时默认给空元素，当开始添加元素的时候在初始化长度
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    @Override
    public boolean add(E e) {
        // 扩容逻辑
        // 确保内部容量，比当前数组内元素个数大一个
        int minCapacity = size + 1;
        // 如果是第一次添加，初始化容量
        if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 判断扩容
        // 需要的最小空间大于当前数组长度时
        if (minCapacity > elementData.length) {
            // 获取当前数组长度
            int oldCapacity = elementData.length;
            // 将长度扩大二分之一作为数组新容量
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            // 如果扩容后的新容量比需要的最少容量小
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            // 重新申请 newCapacity长度的数组空间，将旧的数据搬移过去
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        // 添加元素
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean remove(int index) {
        E oldValue = (E) elementData[index];
        // 需要移动的元素数量
        int numMoved = size-1-index;
        if (numMoved > 0) {
            // 从下标 index+1 开始拷贝 numMoved 个元素到下标 index 开始的位置，依次排列。
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        return false;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

}
