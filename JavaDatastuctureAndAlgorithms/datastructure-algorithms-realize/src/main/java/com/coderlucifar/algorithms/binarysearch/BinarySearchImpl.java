package com.coderlucifar.algorithms.binarysearch;

/**
 * 二分查找实现类
 *      1、用非递归的方式在数组上实现二分查找
 *      2、用递归的方式在数组上实现二分查找
 *
 *  有兴趣可以在链表上实现一下二分查找，不过并没有什么意义，
 *  在链表上无法利用数组基于下标快速访问的特性，每次查找都需要遍历，
 *  时间消耗大。
 *
 */
public class BinarySearchImpl {

    /**
     * 在升序有序数组上的二分查找
     * 非递归实现
     * 说明：只找到一个符合条件的结果
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    public final static int binarySearch(int[] arr, int l, int r, int target) {
        int index = -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == target) {
                index = mid;
                return index;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    /**
     * 在升序有序数组上的二分查找
     * 递归实现
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    public final static int recurseBinarySearch(int[] arr, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r-l)/2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recurseBinarySearch(arr, l, mid-1, target);
        } else {
            return recurseBinarySearch(arr, mid+1, r, target);
        }
    }

    /**
     * 方法测试
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = {-1,0,3,5,9,12};
        int[] arr = {1,3,5,7,9,11,12};
        int res = BinarySearchImpl.binarySearch(arr1, 0, arr.length - 1, 2);
        System.out.println(res);
        System.out.println();

//        int i = BinarySearchImpl.recurseBinarySearch(arr1, 0, arr.length - 1, 2);
//        System.out.println(i);

    }

}
