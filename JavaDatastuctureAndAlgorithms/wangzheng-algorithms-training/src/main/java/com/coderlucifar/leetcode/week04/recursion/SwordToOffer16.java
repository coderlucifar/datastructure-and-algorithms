package com.coderlucifar.leetcode.week04.recursion;

/**
 * 数值的整数次方：
 *      实现pow(x,n) 即计算x的n次幂函数(即，x^n) 。
 *      不得使用库函数，同时不需要考虑大数问题。
 *
 *      提示：
 *          -100.0 < x < 100.0
 *          -2^31 <= n <= 2^31 - 1
 *          2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class SwordToOffer16 {
    class Solution {
        public double myPow(double x, int n) {
            if (n >= 0) return myPowImpl(x, n);
            else {
                //return 1 / myPowImpl(x, -n);    // 当 n为-2147483648时，变为正数会越界，实际上-n还是-2147483648
                return 1 / (myPowImpl(x, -(n + 1)) * x);
            }
        }

        /**
         * 递归求解x的n次幂
         * n 大于 0的情况
         * @param x
         * @param n
         * @return
         */
        private double myPowImpl(double x, int n) {
            //特殊情况处理
            if (x == 0) return (double) 0;
            if (n == 0) return (double) 1;
            //递归边界

            //问题拆解为子问题
            double halfValue = myPowImpl(x, n >> 1);
            //已知子问题的解求解原问题
            if (n % 2 == 0) {
                return halfValue * halfValue;
            } else {
                return halfValue * halfValue * x;
            }
        }
    }

    public static void main(String[] args) {
        SwordToOffer16 swordToOffer16 = new SwordToOffer16();
        Solution solution = swordToOffer16.new Solution();
        double v = solution.myPow(1.00000, -2147483648);
        System.out.println(v);
        System.out.println(-1 >> 1);
        System.out.println(-1 / 2);
        System.out.println(-2147483648 >> 1);
    }

}
