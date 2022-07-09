package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * leetcode744: 寻找比目标字母大的最小字母(Find Smallest Letter Greater Than Target)
 *
 */
public class Leetcode744 {
    class Solution {
        public char nextGreatestLetter_method1(char[] letters, char target) {
            for(int i = 0; i < letters.length; i++) {
                if((letters[i]-'0') > (target-'0')) return letters[i];
            }
            return letters[0];
        }

        public char nextGreatestLetter_method2(char[] letters, char target) {
            int low = 0;
            int high = letters.length - 1;
            while (low <= high) {
                int mid = low + (high-low)/2;
                if ((letters[mid]-'0') > (target-'0')) {
                    //边界条件处理
                    if (mid == 0) return letters[mid];
                    //向左探测
                    if ((letters[mid-1]-'0') <= (target-'0')) {
                        return letters[mid];
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low = mid + 1;
                }
            }
            return letters[0];
        }

    }

    public static void main(String[] args) {

    }
}
