package com.coderlucifar.leetcode.week05.binarySearch.type1;

/**
 * 程序员面试金典：面试题1005 稀疏数组搜索：
 *      稀疏数组搜索。
 *      有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 */
public class Gold1005 {
    class Solution {
        public int findString(String[] words, String s) {
            int low = 0;
            int high = words.length-1;
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(s.equals(words[mid])) {
                    return mid;
                } else if("".equals(words[mid])) {
                    //注意看下面的写法，就是为了缩小搜索区间
                    if(words[low].equals(s)) {
                        //如果最低边界值符合要求，就返回
                        return low;
                    } else {
                        //将左边界像右移动
                        low++;
                    }
                } else if(words[mid].compareTo(s) < 0){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
