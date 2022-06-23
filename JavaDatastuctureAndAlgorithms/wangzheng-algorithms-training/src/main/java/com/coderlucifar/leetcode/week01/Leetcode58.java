package com.coderlucifar.leetcode.week01;

/**
 * leetcode58题：最后一个单词的长度
 *      给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。
 *      返回字符串中最后一个单词的长度。
 *      单词仅由字母组成，不包含任何空格字符的最大子字符串。
 */
public class Leetcode58 {
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();
            int i = chars.length - 1;
            int l = 0;
            while (i >= 0) {
                if (!isAlpha(chars[i])) {
                    i--;
                } else {
                    l++;
                    i--;
                    //注意这里对于边界条件的处理
                    if ((i < 0) || !isAlpha(chars[i])) {
                        return l;
                    }
                }
            }
            return 0;
        }

        private boolean isAlpha(char c) {
            if (c >= 'a' && c <= 'z') return true;
            if (c >= 'A' && c <= 'Z') return true;
            return false;
        }

    }

    public static void main(String[] args) {
        Leetcode58 leetcode58 = new Leetcode58();
        Solution solution = leetcode58.new Solution();
        String s1 = "Hello World";
        String s2 = "    fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";
        String s4 = "a";
        String s5 = "day";
        int i = solution.lengthOfLastWord(s5);
        System.out.println(i);
    }
}
