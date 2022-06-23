package com.coderlucifar.leetcode.week01;

/**
 * 剑指offer05. 替换空格:
 *      请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class SwordToOffer05 {
    class Solution {
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int spaceNum = 0;
            //循环统计空格字符的个数
            while (i < chars.length) {
                if (chars[i] == ' ') {
                    spaceNum++;
                    i++;
                } else {
                    i++;
                }
            }
            char[] newChar = new char[chars.length + spaceNum * 2];
            int p = 0;
            int j = 0;
            while (j < chars.length) {
                if (chars[j] != ' '){
                    newChar[p] = chars[j];
                    j++;
                    p++;
                } else {
                    newChar[p++] = '%';
                    newChar[p++] = '2';
                    newChar[p++] = '0';
                    j++;
                }
            }
            return new String(newChar);
        }


    }

    public static void main(String[] args) {
        SwordToOffer05 swordToOffer05 = new SwordToOffer05();
        Solution solution = swordToOffer05.new Solution();
        String s = "We are happy";
        String replaceSpace = solution.replaceSpace(s);
        System.out.println(replaceSpace);
    }
}
