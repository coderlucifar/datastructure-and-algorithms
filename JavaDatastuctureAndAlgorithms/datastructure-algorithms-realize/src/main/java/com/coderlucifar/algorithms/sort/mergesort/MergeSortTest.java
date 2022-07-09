package com.coderlucifar.algorithms.sort.mergesort;

/**
 * 在数组上进行归并排序
 */
public class MergeSortTest {

    /**
     * 对数组进行归并排序
     * @param arr
     * @param left
     * @param right
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle+1, right);
        merge(arr, left, middle, right);
    }

    /**
     * 合并两个有序数组
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    private void merge(int[] arr, int l, int m, int r) {
        //临时数组
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while ((i <= m) && (j <= r)) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i];
                i++;
            }else {
                tmp[k++] = arr[j];
                j++;
            }
        }
        while (i <= m) {
            tmp[k++] = arr[i];
            i++;
        }
        while (j <= r) {
            tmp[k++] = arr[j];
            j++;
        }
        for (int n = 0; n < tmp.length; n++) {
            arr[l++] = tmp[n];
        }
    }

    public static void main(String[] args) {
        MergeSortTest mergeSortTest = new MergeSortTest();
        int[] arr2 = new int[]{9,6,7,2,5,4,8,2};
        mergeSortTest.mergeSort(arr2, 0, 7);
        for (int i : arr2) {
            System.out.println(i);
        }
    }
}
