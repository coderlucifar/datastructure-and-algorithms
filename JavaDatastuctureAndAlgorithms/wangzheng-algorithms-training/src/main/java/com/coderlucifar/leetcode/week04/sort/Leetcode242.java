package com.coderlucifar.leetcode.week04.sort;

import java.util.Arrays;

/**
 * leetcode242题：有效的字母异位词(简单)：
 *      给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s的
 *      字母异位词语。
 *
 * 注意：若s 和 t中的每个字符出现的次数都相同，则称s和t互为字母异位词。
 *
 *
 */
public class Leetcode242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            if(str1.length != str2.length) return false;
            Arrays.sort(str1);
            Arrays.sort(str2);
            for (int i = 0; i < str1.length; i++) {
                if ((str1[i]-str2[i]) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
