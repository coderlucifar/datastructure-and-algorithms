package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  leetcode1122: 数组的相对排序
 *      给你两个数组，arr1 和 arr2，arr2中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 *      对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。
 *      未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 *
 *   解法：
 *      解法一：利用哈希表。
 *      解法二：由于数据范围不是很大，可以利用计数排序的思想求解。
 *
 */
public class Leetcode1122 {
    class Solution {

        /**
         * 基于哈希表的思想求解
         * @param arr1
         * @param arr2
         * @return
         */
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            if (arr2.length <= 0) {
                Arrays.sort(arr1);
                return arr1;
            }
            if (arr1.length <= 0) {
                return arr1;
            }
            // 构建字典
            Map<Integer,Integer> map = new HashMap<>();
            for (int i : arr2) {
                map.put(i, 0);
            }
            // 在arr1中存在，在arr2中不存在的元素列表
            List<Integer> excludeList = new ArrayList<>();
            for (int j : arr1) {
                if (map.containsKey(j)) {
                    map.put(j, map.get(j) + 1);
                } else {
                    excludeList.add(j);
                }
            }
            List<Integer> resList = new ArrayList<>();
            for (int i : arr2) {
                int num = map.get(i);
                if (num > 0) {
                    for (int j = 0; j < num; j++) {
                        resList.add(i);
                    }
                } else {
                    continue;
                }
            }
            List<Integer> sortedList = excludeList.stream().sorted(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }).collect(Collectors.toList());
            resList.addAll(sortedList);
            int[] result = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                result[i] = resList.get(i);
            }
            return result;
        }
    }
}
