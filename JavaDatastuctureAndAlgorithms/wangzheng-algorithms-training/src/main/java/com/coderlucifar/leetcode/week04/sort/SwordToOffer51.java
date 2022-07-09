package com.coderlucifar.leetcode.week04.sort;

/**
 *  剑指Offer51. 数组中的逆序对(困难):
 *      在数组中的两个数字，如果前面一个数字大于后面的数字，
 *      则这两个数字组成一个逆序对。
 *      输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  示例1：
 *      输入：[7,5,6,4]
 *
 *  输出：5
 *
 *  限制：
 *  0 <= 数组长度 <= 50000
 *
 *  思路：
 *      可以利用快排，统计交换次数，没交换换一次逆序度减一，有序度加一。
 *      最后统计总的交换次数就能直到逆序对的总数是多少了。
 *
 */
public class SwordToOffer51 {
    class Solution {
        private int total = 0;
        private int count = 0;
        public int reversePairs(int[] nums) {
            quickSort(nums, 0 , nums.length-1);
            return total;
        }

        /**
         * 快速排序
         * @param nums
         * @param currentLeft
         * @param currentRight
         */
        private void quickSort(int[] nums, int currentLeft, int currentRight) {
            if (currentLeft >= currentRight) return;
            int partition = partition(nums, currentLeft, currentRight);
            quickSort(nums, currentLeft, partition-1);
            quickSort(nums, partition+1, currentRight);
        }

        /**
         * 分区并返回分区点
         * @param nums
         * @param currentLeft
         * @param currentRight
         * @return
         */
        private int partition(int[] nums, int currentLeft, int currentRight) {
            int i = currentLeft - 1;
            for (int j = currentLeft; j < currentRight; j++) {
                if (nums[j] < nums[currentRight]) {
                    swap(nums, i+1, j);
                    if ((i+1) != j) {
                        total = total + count;
                        count = 0;
                    }
                    i++;
                } else {
                    count++;
                    continue;
                }
            }
            swap(nums, i+1, currentRight);
            if ((i + 1) != currentRight) {
                total++;
            }
            return i+1;
        }

        /**
         * 交换数组中两个元素
         * @param nums
         * @param i
         * @param j
         */
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

    public static void main(String[] args) {
        SwordToOffer51 swordToOffer51 = new SwordToOffer51();
        Solution solution = swordToOffer51.new Solution();
        int[] arr = new int[]{7,5,6,4};
        int res = solution.reversePairs(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println(res);
    }
}
