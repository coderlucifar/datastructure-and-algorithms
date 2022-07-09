package com.coderlucifar.leetcode.week04.sort;
import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode56：合并区间:
 *      以数组intervals表示若干个区间的集合，其中单个区间为intervals[i] = [starti, endi]。
 *      请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  示例1：
 *      输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *      输出：[[1,6],[8,10],[15,18]]
 *      解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *  示例2：
 *      输入：intervals = [[1,4],[4,5]]
 *      输出：[[1,5]]
 *      解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *   提示：
 *      1 <= intervals.length <= 104
 *      intervals[i].length == 2
 *      0 <= starti <= endi <= 104
 *
 *
 *   基本处理思路是：
 *      1、先对二维数组中的一维数组进行排序。
 *      2、申请一个临时数组，初始化为第一个数组
 *      3、从第二个数组开始与临时数组用判断函数判断，如果可以合并，则合并,合并之后放入结果数组，然后将临时数组的值置为下一个数组。
 *      如此循环往复，直到处理完所有的元素。
 *
 */
public class Leetcode56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //边界情况处理
            if (intervals.length <= 0) return new int[0][0];
            if (intervals.length == 1) return intervals;
            //按左边界值大小对区间排序
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] - o2[0]);
                }
            });
            //初始化临时数组
            int[] tmp = intervals[0];
            //初始化结果数组（先指定为原始数组大小）
            int[][] result = new int[intervals.length][];
            //当前数组中元素个数
            int count = 0;
            //遍历填充
            for (int i = 1; i < intervals.length; i++) {
                if (canMerge(tmp,intervals[i])) {
                    int[] merge = merge(tmp, intervals[i]);
                    tmp = merge;
                } else {
                    result[count++] = tmp;
                    tmp = intervals[i];
                }
            }
            //将最后一个元素加入结果数组
            result[count++] = tmp;
            //构造题目需要的返回结果
            int[][] res = new int[count][2];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = result[i][j];
                }
            }
            return res;
        }

        /**
         * 合并操作
         * 说明：处理的数组，必须已经按数组第一个元素的大小顺序，从小到大排好序
         * @return
         */
        private int[] merge(int[] before, int[] after){
            int[] result = new int[2];
            if ((before[0] <= after[0]) && (before[1] >= after[1])) {
                result[0] = before[0];
                result[1] = before[1];
            } else {
                result[0] = before[0];
                result[1] = after[1];
            }
            return result;
        }

        /**
         * 判断是否能合并
         * @param before
         * @param after
         * @return
         */
        private boolean canMerge(int[] before, int[] after) {
            if (before[1] >= after[0]){
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode56 leetcode56 = new Leetcode56();
        Solution solution = leetcode56.new Solution();
//        int[][] arr = new int[][]{{1,5},{2,3},{1,3},{3,8},{9,16},{4,7},{10,13}};
        int[][] res = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = solution.merge(res);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
}
