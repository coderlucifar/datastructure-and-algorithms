package com.coderlucifar.algorithms.sort.quicksort;

/**
 * 在数组上进行快速排序
 */
public class QuickSortTest {

    /**
     * 递归实现快速排序
     * @param arr 原始数组
     * @param currentLeft 当前左边界
     * @param currentRight 当前右边界
     */
    private void quickSort(int[] arr, int currentLeft, int currentRight) {
        //递归终止条件
        if (currentLeft >= currentRight) return;
        //分区操作，返回分区后的分区点
        int partition = partition(arr, currentLeft, currentRight);
        //对左分区递归
        quickSort(arr, currentLeft, partition-1);
        //对右分区递归
        quickSort(arr, partition+1, currentRight);
    }

    /**
     * 分区操作：下面的实现方式约定选择当前区间右边界的值作为分区点的值，分区后返回分区点下标。
     * 如何分区？
     *      选择当前右边界，即currentRight作为分区值
     *      [currentLeft,i]为比分区值小的区间，
     *      [i+1,j]为比分区值大的区间，[j, currentRight-1]为未处理的区间
     *      遍历数组，填充两个区间。
     *      遍历结束后，将i+1位置的值与当前右边界的值交换，
     *      i+1为分区点，返回分区点。
     * @param arr
     * @param currentLeft
     * @param currentRight
     * @return 分区点
     */
    private int partition(int[] arr, int currentLeft, int currentRight) {
        /**
         * 初始化比分区值小的区间。
         * 为啥要这么初始化？
         *   因为当前这个区间一个元素也没有！！！
         *   每出现一个比分区值小的元素，这个区间就会扩充1
         */
        int i = currentLeft - 1;
//        int i = currentLeft;
        //遍历处理，直到处理完右边界的前一个元素
        for (int j = currentLeft; j < currentRight; j++) {
            if (arr[j] < arr[currentRight]) {
                //如果当前元素小于分区值
                //就将当前元素与 当前 小值区间的右相邻元素交换
                swap(arr, i+1, j);
//                swap(arr, i, j);
                //小值区间右边界移动
                i++;
            } else {
                //如果当前元素大于分区值，跳过当前元素进入下轮循环。
                continue;
            }
        }
//        swap(arr, i, currentRight);
        //将分区值与小区间右边界相邻元素交换位置
        swap(arr, i+1, currentRight);
//        return i;
        //返回分区点
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,6,5,8,3,2,1};
        QuickSortTest quickSortTest = new QuickSortTest();
        quickSortTest.quickSort(arr, 0, 6);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
