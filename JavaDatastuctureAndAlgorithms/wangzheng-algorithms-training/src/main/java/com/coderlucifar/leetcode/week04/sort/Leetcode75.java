package com.coderlucifar.leetcode.week04.sort;

/**
 * leetcode75：颜色分类(中等):
 *      给定一个包含红色、白色和蓝色、共n个元素的数组nums,
 *      原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、
 *      蓝色顺序排列。
 *      我们使用整数0、1和2分别表示红色、白色和蓝色。
 *      必须在不使用sort函数的情况下解决这个问题。
 *
 *  提示：
 *      n == nums.length
 *      1 <= n <= 300
 *      nums[i] 为 0、1 或 2
 */
public class Leetcode75 {
    class Solution {
        public void sortColors(int[] nums) {
            quickSort(nums, 0, nums.length-1);
        }

        private void quickSort(int[] nums, int currentLeft, int currentRight) {
            if (currentLeft >= currentRight) return;
            int partition = partition(nums, currentLeft, currentRight);
            quickSort(nums, currentLeft, partition-1);
            quickSort(nums, partition+1, currentRight);
        }

        private int partition(int[] nums, int l, int r) {
            int i = l - 1;
            for (int j = l; j < r; j++) {
                if (nums[j] < nums[r]) {
                    swap(nums, i+1, j);
                    i++;
                }
            }
            swap(nums, i+1, r);
            return i+1;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

    }

    public static void main(String[] args) {
        Leetcode75 leetcode75 = new Leetcode75();
        Solution solution = leetcode75.new Solution();
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }
}
