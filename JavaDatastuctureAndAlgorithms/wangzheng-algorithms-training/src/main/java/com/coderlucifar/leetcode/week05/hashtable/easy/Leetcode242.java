package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *  leetcode242：有效的字母异位词
 *      解法一：排序+双指针
 *      解法二：哈希表
 *
 *      在本章节我们基于哈希表的思想求解
 */
public class Leetcode242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) return false;
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();
            if (s1.length != s2.length) return false;
            Map<Character,Integer> map = new HashMap<>();
            for (char c : s1) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                }
            }
            for (char c : s2) {
                if (map.containsKey(c)) {
                    if (map.get(c) > 1) {
                        map.put(c, map.get(c)-1);
                    } else {
                        map.remove(c);
                    }
                } else {
                    return false;
                }
            }
            if (map.isEmpty()) return true;
            return false;
        }
    }
}
