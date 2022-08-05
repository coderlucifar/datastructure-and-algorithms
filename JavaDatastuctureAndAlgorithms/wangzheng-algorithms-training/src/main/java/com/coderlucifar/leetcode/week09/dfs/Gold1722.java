package com.coderlucifar.leetcode.week09.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词转换（中等）
 *      题目描述：
 *          给定字典中的两个词，长度相等。
 *          写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。
 *          每一步得到的新词都必须能在字典中找到。
 *          编写一个程序，返回一个可能的转换序列。
 *          如有多个可能的转换序列，你可以返回任何一个。
 *
 *      示例：
 *          输入:
 *              beginWord = "hit",
 *              endWord = "cog",
 *              wordList = ["hot","dot","dog","lot","log","cog"]
 *          输出:
 *              ["hit","hot","dot","lot","log","cog"]
 *
 */
public class Gold1722 {
    class Solution {

        private boolean[] visited;
        private List<String> result = new ArrayList<>();
        private boolean find = false;
        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            visited = new boolean[wordList.size()];
            result.add(beginWord);
            dfs(beginWord, endWord, wordList);
            if (!find) return new ArrayList<>();
            else return this.result;
        }

        private void dfs(String currentWord, String targetWord, List<String> wordList) {
            if (currentWord.equals(targetWord)) {
                this.find = true;
                return;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (visited[i]) continue;
                else if (!convert(currentWord, wordList.get(i))) continue;
                else {
                    visited[i] = true;
                    result.add(wordList.get(i));
                    dfs(wordList.get(i), targetWord, wordList);
                    if (find) return;
                    result.remove(result.size()-1);
                }
            }
            return;
        }

        private boolean convert(String currentWord, String nextWord) {
            char[] cW = currentWord.toCharArray();
            char[] nW = nextWord.toCharArray();
            if (cW.length != nW.length) return false;
            int i = 0;
            int count = 0;
            while (i < cW.length) {
                if (cW[i] != nW[i]) {
                    count++;
                }
                i++;
            }
            if (count == 1) return true;
            else return false;
        }

    }
}
