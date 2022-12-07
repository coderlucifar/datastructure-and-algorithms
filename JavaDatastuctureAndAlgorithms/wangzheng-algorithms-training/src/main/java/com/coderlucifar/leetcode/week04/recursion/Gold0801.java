package com.coderlucifar.leetcode.week04.recursion;

/**
 * 程序员面试金典: 08.01.三步问题：
 *      三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 *      实现一种方法，计算小孩有多少种上楼梯的方式。
 *      结果可能很大，你需要对结果取模 1000000007 。
 *
 *      重点：每进行一次运算都需要取模一次，才能保证运算过程中不溢出，以及最后的运算结果不溢出。
 *
 *      提示：
 *          1、n的范围在【1，1000000】之间
 *
 *      注意溢出问题！！！
 *      取模的位置大有讲究！！！
 *      这个题也可以用动态规划求解！
 *
 *      解法一： 用递归
 *
 *      解法二：非递归
 *
 *      做题记录：2022.1110
 *
 */
public class Gold0801 {
    class Solution {
        private final int mod = 1000000007;

        public int waysToStep(int n) {
            int[] rem = new int[n + 1];
            //return waysToStepImpl(n, rem);            // 如果只在最后结果处取模无法解决溢出问题
            return waysToStepImpl2(n);
        }

        /**
         * 递归实现
         * @param n
         * @param rem
         * @return
         */
        private int waysToStepImpl(int n, int[] rem) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (n == 3) return 4;
            if (rem[n] > 0) {
                return rem[n];
            }
            else {
                rem[n] = (((waysToStepImpl(n-1, rem) + waysToStepImpl(n-2, rem)) % mod ) + waysToStepImpl(n-3, rem)) % mod;
            }
            return rem[n];
        }

        /**
         * 非递归实现
         * @param n
         * @return
         */
        private int waysToStepImpl2(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (n == 3) return 4;
            int a = 1;
            int b = 2;
            int c = 4;
            int res = 0;
            for (int i = 4; i <= n; i++) {
                res = (((a + b)%mod) + c) % mod;
                a = b;
                b = c;
                c = res;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Gold0801 gold0801 = new Gold0801();
        Solution solution = gold0801.new Solution();
        int ways = solution.waysToStep(6);
        System.out.println(ways);   // 24

    }
}
