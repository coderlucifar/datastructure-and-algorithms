package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Gold1602：单词频率
 */
public class Gold1602 {

}

class WordsFrequency {
    private Map<String,Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (int i = 0; i < book.length; i++) {
            if (map.containsKey(book[i])) {
                map.put(book[i], map.get(book[i])+1);
            } else {
                map.put(book[i], 1);
            }
        }
    }

    public int get(String word) {
        if (map.containsKey(word)) return map.get(word);
        return 0;
    }
}
