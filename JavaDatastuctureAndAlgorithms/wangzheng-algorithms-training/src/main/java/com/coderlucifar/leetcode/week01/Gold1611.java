package com.coderlucifar.leetcode.week01;

/**
 * 程序员面试金典：面试题16.11.跳水板
 *      你正在使用一堆模板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter,
 *      长度较长的木板长度为longer。你必须正好使用k快木板。编写一个方法，生成跳水板所有可能长度。
 */
public class Gold1611 {
    class Solution {

        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) return new int[]{};
            else if (shorter == longer) return new int[]{shorter*k};
            else {
                int div = longer - shorter;
                int max = longer * k;
                int min = shorter * k;
                int length = (max - min)/div - 1 + 2;
                int[] nums = new int[length];
                for (int i = 0; i < length; i++) {
                    nums[i] = min + (i * div);
                }
                return nums;
            }
        }

    }

    public static void main(String[] args) {
        Gold1611 gold1611 = new Gold1611();
        Solution solution = gold1611.new Solution();
        int[] ints = solution.divingBoard(1, 2, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
