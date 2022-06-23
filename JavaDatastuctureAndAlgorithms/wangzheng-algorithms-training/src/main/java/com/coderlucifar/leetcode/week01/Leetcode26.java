package com.coderlucifar.leetcode.week01;

/**
 * leetcode26: 删除排序数组中的重复项：
 *  给你一个有序数组nums, 请你原地删除重复出现的元素，
 *  使每个元素只出现一次，返回删除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用
 *  O(1)的额外空间下完成。
 */
public class Leetcode26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            int k = 1;
            int n = nums.length;
            // i从1开始，跳过原数组中第一个元素
            //后加入的元素与前一个元素不相等才能加进去
            while (k < n){
                if (nums[k] != nums[i]) {
                    i++;
                    nums[i] = nums[k];
                    k++;
                } else {
                    k++;
                }
            }
            return i+1;
        }
    }

    public static void main(String[] args) {
        Leetcode26 leetcode26 = new Leetcode26();
        Solution solution = leetcode26.new Solution();
        int[] nums = new int[]{1,1,2,2,3,4,5};
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }
}
