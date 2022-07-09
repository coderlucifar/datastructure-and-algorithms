package com.coderlucifar.leetcode.week04.sort;

/**
 * 程序员面试金典：面试题1001 合并排序的数组(简单):
 * 题目描述：给定两个排序后的数组A和B，其中A的末端有足够的缓冲空间容纳B。
 *      编写一个方法，将B合并入A并排序。
 *      初始化A和B的元素数量分别为m和n。
 *
 *  示例：
 *      输入：A = [1,2,3,0,0,0], m = 3
 *           B = [2,5,6],       n = 3
 *      输出：[1,2,2,3,5,6]
 *
 *   说明：A.length == n + m
 */
public class Gold1001 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            //开始放入元素的位置
            int k = m + n - 1;
            //指向数组A中末尾元素的指针
            int i = m - 1;
            //指向数组B中末尾元素的指针
            int j = n - 1;
            //双指针从后往前扫描,比较两个指针所值元素大小，将大的放入待插入位置，更新指针位置
            while (i >= 0 && j >= 0) {
                if (A[i] > B[j]) {
                    A[k--] = A[i];
                    i--;
                } else {
                    A[k--] = B[j];
                    j--;
                }
            }
            //如果B中有剩余元素，将剩余元素搬运到A。
            while (j >= 0) {
                A[k--] = B[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{2,5,6};
        int m = 3,n = 3;
        Gold1001 gold1001 = new Gold1001();
        Solution solution = gold1001.new Solution();
        solution.merge(A, m, B, n);
        for (int i : A) {
            System.out.println(i);
        }
    }
}


