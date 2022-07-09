package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode69： x的平方根
 */
public class Leetcode69 {
    class Solution {
        public int mySqrt(int x) {
            if(x == 0) return 0;
            int low = 0;
            int high = x/2 + 1;
            while(low <= high) {
                int mid = low + (high-low)/2;
                long midR = (long)mid*mid;
                if(midR == x) {
                    return mid;
                } else if (midR > x) {
                    high = mid - 1;
                } else {
                    long midRR = ((long)(mid+1))*(mid+1);
                    if(midRR > x) {
                        return mid;
                    } else if (midRR == x) {
                        return mid+1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
