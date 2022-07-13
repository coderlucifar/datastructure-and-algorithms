package com.coderlucifar.leetcode.week05.hashtable.easy;

/**
 * leetcode706: 设计哈希映射
 */
public class Leetcode706 {

}

class MyHashMap {
    private int[] res = new int[1000001];

    public MyHashMap() {
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
    }

    public void put(int key, int value) {
        res[key] = value;
    }

    public int get(int key) {
        return res[key];
    }

    public void remove(int key) {
        res[key] = -1;
    }
}