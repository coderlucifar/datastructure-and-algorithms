package com.coderlucifar.leetcode.week04.recursion;

/**
 * 剑指Offer10- II. 青蛙跳台阶问题
 */
public class SwordToOffer10g2 {
    class Solution {
        private final int mod = 1000000007;
        int[] remember = new int[101];
        public int numWays(int n) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (remember[n] > 0) {
                return remember[n];
            }
            else {
                remember[n] = (numWays(n-1) + numWays(n-2)) % mod;
            }
            return remember[n];
        }
    }

    public static void main(String[] args) {
        SwordToOffer10g2 swordToOffer10g2 = new SwordToOffer10g2();
        Solution solution = swordToOffer10g2.new Solution();
        int i = solution.numWays(0);
        System.out.println(i);
    }
}
