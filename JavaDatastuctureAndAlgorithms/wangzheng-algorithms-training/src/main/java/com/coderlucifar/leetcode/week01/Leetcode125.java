package com.coderlucifar.leetcode.week01;

/**
 * Leetcode125：验证回文串
 */
public class Leetcode125 {
    class Solution {
        public boolean isPalindrome(String s) {
            //空字符串直接返回
            if("".equals(s)) return true;
            //先将字符串转化为字符数组
            char[] chars = s.toCharArray();
            //双指针扫描数组
            int i = 0;
            int j = chars.length - 1;
            while(i < j) {
               if (!isAlpha(chars[i])) {
                   i++;
               }else if (!isAlpha(chars[j])) {
                   j--;
               }else {
                   if (toLower(chars[i]) == toLower(chars[j])) {
                       if ((i+1) != j) {
                           i++;
                           j--;
                       } else {
                           return true;
                       }
                   } else {
                       return false;
                   }
               }
            }
            return true;
        }

        /**
         * 判断是不是数字或字母
         * @param c
         * @return
         */
        private boolean isAlpha(char c) {
            if (c >= '0' && c <= '9') return true;
            if (c >= 'a' && c <= 'z') return true;
            if (c >= 'A' && c <= 'Z') return true;
            return false;
        }

        /**
         * 输入字母或数字字符
         * 将大写字符转为小写
         * @param c
         * @return
         */
        private char toLower(char c) {
            if (c >= 'a' && c <= 'z') return c;
            if (c >= '0' && c <= '9') return c;
            return (char) ((int)c + 32);
        }

    }

    public static void main(String[] args) {
        Leetcode125 leetcode125 = new Leetcode125();
        Solution solution = leetcode125.new Solution();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        boolean palindrome = solution.isPalindrome("race a car");
        System.out.println(palindrome);
    }
}
