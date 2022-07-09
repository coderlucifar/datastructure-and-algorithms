package com.coderlucifar.leetcode.week04.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode252: 会议室（简单）
 *      给定一个会议时间安排的数组intervals，
 *      每个会议时间都会包括开始和结束的时间
 *      intervals[i] = [starti, endi]
 *      请你判断一个人是否能够参加这里面的全部会议。
 *
 */
public class Leetcode252 {
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if (intervals.length <= 1) return true;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] - o2[0]);
                }
            });
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < intervals[i-1][1]) return false;
            }
            return true;
        }
    }
}
