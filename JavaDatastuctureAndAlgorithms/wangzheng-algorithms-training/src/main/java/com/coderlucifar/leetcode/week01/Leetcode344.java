package com.coderlucifar.leetcode.week01;

/**
 * leetcode344题：反转字符串
 *  编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *  不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Leetcode344 {

    class Solution {
        public void reverseString(char[] s) {
            for (int i = 0,j = s.length-1; i < s.length/2; i++,j--) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String str = "hello";
        char[] chars = str.toCharArray();
        Leetcode344 leetcode344 = new Leetcode344();
        Solution solution = leetcode344.new Solution();
        solution.reverseString(chars);
        System.out.println(chars);
    }

}
