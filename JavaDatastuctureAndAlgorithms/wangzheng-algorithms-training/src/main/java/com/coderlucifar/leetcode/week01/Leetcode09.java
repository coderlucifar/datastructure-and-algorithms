package com.coderlucifar.leetcode.week01;

/**
 * leetcode09题：回文数
 */
public class Leetcode09 {
    class Solution  {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            //先把整数转换为字符串
            String s = x + "";
            //在把字符串转换为字符数组
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                if (chars[i] != chars[j]) {
                    return false;
                } else {
                    if ((i + 1) != j) {
                        i++;
                        j--;
                    } else {
                        return true;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Leetcode09 leetcode09 = new Leetcode09();
        Solution solution = leetcode09.new Solution();
        boolean palindrome = solution.isPalindrome(121);
        System.out.println(palindrome);
    }
}
