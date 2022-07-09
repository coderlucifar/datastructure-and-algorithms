package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode367：有效的完全平方数
 *
 */
public class Leetcode367 {
    class Solution {
        //如果num是个完全平方数就返回true，否则返回false
        public boolean isPerfectSquare(int num) {
            if(num == 0) return true;
            int low = 0;
            int high = num/2 + 1;
            while(low <= high) {
                int mid = low + (high-low)/2;
                long midR = (long)mid*mid;
                if(midR == num) {
                    return true;
                } else if (midR < num) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return false;
        }
    }
}
