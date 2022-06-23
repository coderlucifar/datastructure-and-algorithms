package com.coderlucifar.leetcode.week04.recursion;

/**
 * 剑指Offer 10-1. 斐波那契数列
 */
public class SwordToOffer10g1 {
    class Solution {
        public int fib(int n) {
            int[] remember = new int[n+1];
            int value = fib_r(n, remember);
            int res = (value % 1000000007);
            return res;
        }
        private int fib_r(int n, int[] remember) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (remember[n] > 0) {
                return remember[n];
            }
            else {
                remember[n] = fib_r(n - 1, remember) + fib_r(n - 2, remember);
            }
            return remember[n];
        }
    }

    public static void main(String[] args) {
        SwordToOffer10g1 swordToOffer10g1 = new SwordToOffer10g1();
        Solution solution = swordToOffer10g1.new Solution();
        int fib = solution.fib(9);
        System.out.println(fib);
    }
}
