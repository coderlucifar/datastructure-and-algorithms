package com.coderlucifar.leetcode.week01;

/**
 * 剑指Offer61: 扑克牌中的顺子
 *      从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这5张牌不是连续的。
 *      2～10为数字本身，A为1，J为11，Q为12，K为13，而大小王为0，可以看成任意数字。
 *      A不是视为14。
 *
 *      0可以当成任何数字
 *
 */
public class SwordToOffer61 {
    class Solution {
        public boolean isStraight(int[] nums) {
            //用来记录重复的数字
            boolean[] dup = new boolean[14];
            int zeroNum = 0;
            int max = -1;
            int min = 100;
            for (int num : nums) {
                //找到最大值
                if (num > max) max = num;
                //找到除0外的最小值
                if ((num < min) && (num != 0)) min = num;

                if (num == 0) zeroNum++;
                if (!dup[num]) {
                    dup[num] = true;
                } else {
                    if (num != 0) return false;
                }
            }

            int c = max - min;

            //如果0的个数是0
            if ((zeroNum == 0) && (c == 4)) return true;
            //如果0的个数是1
            if ((zeroNum == 1) && (c >= 3) && (c <= 4)) return true;
            //如果0的个数是2
            if ((zeroNum == 2) && (c >= 2) && (c <= 4)) return true;
            //3个0
            if ((zeroNum == 3) && (c >= 1) && (c <= 4)) return true;
            //4个0
            if (zeroNum > 3) return true;

            return false;
        }
    }

    public static void main(String[] args) {
        SwordToOffer61 swordToOffer61 = new SwordToOffer61();
        Solution solution = swordToOffer61.new Solution();
        int[] nums = new int[]{1,2,3,4,5};
        boolean straight = solution.isStraight(nums);
        System.out.println(straight);
    }
}
