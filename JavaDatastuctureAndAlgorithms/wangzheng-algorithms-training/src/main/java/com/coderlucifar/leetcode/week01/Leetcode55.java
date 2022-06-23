package com.coderlucifar.leetcode.week01;

/**
 * 第一次做没解出来，有点像脑筋急转弯。
 * 需要总结出规律才能破解，如果直接翻译难以实现。
 *
 * 看了题解之后默写一遍
 *
 * leetcode55题：跳跃游戏
 *      给定一个非负整数数组nums, 你最初位于数组的第一个下标。
 *      数组中的每个元素代表你在该位置可以跳跃的 最大长度（也就是说比他短的长度也可以任意跳） 。
 *      判断你是否能够到达最后一个下标
 *
 *  leetcode精彩评论:
 *      想象你是那个在格子上行走的小人，格子里面的数字代表“能量”，你需要“能量”才能继续行走。
 *      每次走到一个格子的时候，你检查现在格子里面的“能量”和你自己拥有的“能量”哪个更大，取更大的“能量”！
 *      如果你有更多的能量，你就可以走的更远啦！~
 *
 *
 */
public class Leetcode55 {
    class Solution {
        public boolean canJump(int[] nums) {
            //用来表示当前已到达的最大长度
            int reachedMax = 0;
            //循环整个数组
            for (int i = 0; i < nums.length; i++) {
                //如果当前指针位置已经大于了当前已到达的最大位置，则到不了终点
                if (i > reachedMax) return false;
                //如果当前已到达的最大位置小于 下一跳能到达的最大位置
                if (reachedMax < (i + nums[i])) {
                    //更新已到达的最大位置
                    reachedMax = i + nums[i];
                }
                //如果已到达的最大位置已经超过了终点
                if (reachedMax >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Leetcode55 leetcode55 = new Leetcode55();
        Solution solution = leetcode55.new Solution();
        int[] nums1 = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,4};
        int[] nums3 = new int[]{1};
        boolean b = solution.canJump(nums2);
        System.out.println(b);
    }
}
