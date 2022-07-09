package com.coderlucifar.leetcode.week04.sort;

import com.coderlucifar.leetcode.week03.Gold1626;

/**
 * 程序员面试金典：最小K个数(中等)：
 *      题目描述：
 *          设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *      示例：
 *          输入：arr = [1,3,5,,7,2,4,6,8], k = 4
 *          输出：[1,2,3,4]
 *      提示：
 *          0 <= len(arr) <= 10,0000
 *          0 <= k <= min(100000, len(arr))
 *
 */
public class Gold1714 {
    class Solution {
        //结果数组
        private int[] result;
        //数组当前可插入位置下标
        private int count = 0;
        public int[] smallestK(int[] arr, int k) {
            if (k <= 0 || k > arr.length) return new int[0];
            //结果数组
            result = new int[k];
            //利用快排求解
            quickSort(arr, 0, arr.length-1, k);
            return result;
        }
        //利用快排找到最小的k个数，并把它们搬运到结果数组中
        private void quickSort(int[]arr, int l, int r, int k) {
            //递归结束条件
//            if (l >= r) return;
            if (l > r) return;  //为啥这里不能有=号？因为当左右边界相等的时候，这个数据也有可能需要搬运到结果数组中3
            //获取分区点
            int partition = partition(arr, l, r);
            if ((partition-l+1) == k) {
                for (int i = l; i <= partition; i++) {
                    result[count++] = arr[i];
                }
            } else if ((partition-l+1) < k) {
                for (int i = l; i <= partition; i++) {
                    result[count++] = arr[i];
                }
                quickSort(arr, partition+1, r, k-(partition-l+1));
            } else {
                quickSort(arr, l, partition-1, k);
            }
        }

        /**
         * 分区操作并获取分区后的分区点下标；
         * 约定：分区点每回选择当前区间右边界
         * @param arr 原始数组
         * @param l 当前区间左边界
         * @param r 当前区间右边界
         * @return 分区点下标
         */
        private int partition(int[] arr, int l, int r) {
            //初始化小值区间
            int i = l - 1;
            //分区操作
            for (int j = l; j < r; j++) {
                if (arr[j] < arr[r]) {
                    swap(arr, i+1, j);
                    i++;
                } else {
                    continue;
                }
            }
            swap(arr, i+1, r);
            //返回新的分区点
            return i+1;
        }

        /**
         * 交换数组两个位置的值
         * @param arr
         * @param i
         * @param j
         */
        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Gold1714 gold1714 = new Gold1714();
        Solution solution = gold1714.new Solution();
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        solution.smallestK(arr, k);
        for (int i : solution.result) {
            System.out.printf("%d ", i);
        }
    }
}
