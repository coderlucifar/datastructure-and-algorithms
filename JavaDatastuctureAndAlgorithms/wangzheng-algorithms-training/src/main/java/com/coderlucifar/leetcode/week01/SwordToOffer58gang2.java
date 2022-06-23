package com.coderlucifar.leetcode.week01;

/**
 * 剑指Offer 58 - II. 左旋转字符串：
 *      字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *      请定义一个函数实现字符串左旋转操作中的功能。
 *      比如，输入字符串"abcdefg"和数字2，该函数将返回"cdefgab"。
 */
public class SwordToOffer58gang2 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            //转字符数组
            char[] chars = s.toCharArray();
            char[] newChars = new char[chars.length];
            int i = 0;
            int j = n;
            while (j < chars.length) {
                newChars[i] = chars[j];
                i++;
                j++;
            }
            if (j == chars.length) {
                int k = 0;
                while (k < n) {
                    newChars[i] = chars[k];
                    i++;
                    k++;
                }
            }
            return new String(newChars);
        }
    }

    public static void main(String[] args) {
        SwordToOffer58gang2 swordToOffer58gang2 = new SwordToOffer58gang2();
        Solution solution = swordToOffer58gang2.new Solution();
        String s = "abcdefg";
        int n = 3;
        String reverseLeftWords = solution.reverseLeftWords(s, n);
        System.out.println(reverseLeftWords);
    }
}
