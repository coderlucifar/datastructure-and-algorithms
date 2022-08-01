package com.coderlucifar.leetcode.week05.hashtable.medium;

import java.util.HashMap;

/**
 *  leetcode146: LRU(最近最少使用)缓存机制
 *         请你设计并实现一个满足LRU(最近最少使用)缓存约束的数据结构。
 *          实现 LRUCache 类：
 *
 *              LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 *
 *              int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *
 *              void put(int key, int value)如果关键字key已经存在，则变更其数据值value ；
 *              如果不存在，则向缓存中插入该组key-value 。
 *              如果插入操作导致关键字数量超过capacity ，则应该逐出最久未使用的关键字。
 *              函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *      解法一、使用java类库提供的HashMap加LinkedList实现
 *
 */
public class Leetcode146 {
    public static void main(String[] args) {

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

    // 定义双链表的节点
    private class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 哈希表
    private HashMap<Integer, DLinkedNode> hashTable = new HashMap<>();

    // 缓存最大容量
    private int capacity;
    // 当前已使用容量
    private int size;
    // 哨兵头节点
    private DLinkedNode head;
    // 哨兵尾节点
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        // 初始化最大容量
        this.capacity = capacity;
        // 初始化当前容量
        this.size = 0;
        // 初始化哨兵节点
        this.head = new DLinkedNode(-1,-1);
        this.tail = new DLinkedNode(-1, -1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    /**
     * 从LRU中获取元素
     * @param key
     * @return
     */
    public int get(int key) {
        if (hashTable.containsKey(key)) {
            DLinkedNode node = hashTable.get(key);
            if (node != null) {
                // 将当前节点搬移到双向链表的头部
                // 将该节点从当前位置删除
                removeNode(node);
                // 将该节点放到头部
                insertNodeAfterHead(node);
                // 返回节点值
                return node.value;
            }
        }
        return -1;
    }

    /**
     * 从链表中删除节点
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * 头插法
     * @param node
     */
    private void insertNodeAfterHead(DLinkedNode node) {
        if (node != null) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }
    }

    /**
     * 往LRU中插入元素
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 如果当前key已经存在，替换值，但是需要移动节点位置
        if (this.hashTable.containsKey(key)) {
            DLinkedNode node = this.hashTable.get(key);
            if (node != null) {
                // 将当前节点搬移到双向链表的头部
                // 将该节点从当前位置删除
                removeNode(node);
                // 将该节点放到头部
                insertNodeAfterHead(node);
                // 改变节点值
                node.value = value;
                return;
            }
        }

        // 如果当前容量已满，把尾节点删除
        if (this.size == this.capacity) {
            // 从哈希表中删除
            this.hashTable.remove(this.tail.prev.key);
            // 从双向链表中删除
            removeNode(this.tail.prev);
            // 当前已有元素个数减一
            this.size = this.size - 1;
        }

        // 创建一个新节点并放到双向链表头部
        DLinkedNode node = new DLinkedNode(key, value);
        // 放到哈希表中
        hashTable.put(key, node);
        // 放到双向链表中
        insertNodeAfterHead(node);
        // 当前已有元素个数加一
        size = size + 1;
    }
}


