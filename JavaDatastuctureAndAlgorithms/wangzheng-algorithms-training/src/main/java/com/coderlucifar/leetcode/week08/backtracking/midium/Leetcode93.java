package com.coderlucifar.leetcode.week08.backtracking.midium;

import java.util.ArrayList;
import java.util.List;

/**
 *  leetcode93：复原IP地址（中等）
 *      题目描述：
 *          有效 IP 地址 正好由四个整数
 *         （每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 *          例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 *          但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *          给定一个只包含数字的字符串 s ，用以表示一个IP地址，
 *          返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。
 *          你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *      提示：
 *          1 <= s.length <= 20
 *          s 仅由数字组成
 *
 *      分析：
 *          一共要做三个阶段的决策，每个阶段决定一个点的位置，当三个点都放好之后，检测最终的结果是否合法，合法就放入结果集当中。
 */
public class Leetcode93 {
    class Solution {

        List<String> result = new ArrayList<>();

        // 路径，存 我们要把点放在哪个 数组下标后面
        List<Integer> path = new ArrayList<>();

        // 阶段(一共有三个阶段，每个阶段选择一个点的位置)
        private int stage = 0;

        private final static int END = 3;

        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
            char[] ip = s.toCharArray();
            int length = ip.length;
            trace(ip, 0, 2, length);
            return this.result;
        }

        private void trace(char[] ip, int start, int end, int length) {

            if (stage == END && this.path.size() == 3) {
                StringBuffer buffer = new StringBuffer();
                int count = 0;
                for (int i = 0; i < ip.length; i++) {
                    buffer.append(ip[i]);
                    if (count < 3) {
                        if (this.path.get(count) == i) {
                            buffer.append('.');
                            count++;
                        }
                    }
                }
                String possibleAnswer = buffer.toString();
                if (answer(possibleAnswer)) {
                    this.result.add(possibleAnswer);
                }
                return;
            }

            for (int i = start; i <=end; i++) {
                if (i >= length-1) return;
                path.add(i);
                stage++;

                trace(ip, i+1, i+3, length);

                stage--;
                path.remove(stage);
            }

            return;
        }

        private boolean answer(String possibleAnswer) {
            String[] nums = possibleAnswer.split("\\.");
            for (String num : nums) {
                if (!valid(num)) return false;
            }
            return true;
        }

        private boolean valid(String num) {
            char[] digits = num.toCharArray();
            int length = digits.length;
            if (length <= 0 || length > 3) {
                return false;
            }
            else if (length > 1) {
                if (digits[0] == '0') return false;
                if (length > 2 ) {
                    int value = Integer.valueOf(num);
                    if (value > 255) return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        Solution solution = leetcode93.new Solution();
        String str = "25525511135";
        List<String> strings = solution.restoreIpAddresses(str);
        System.out.println("end");

    }

}
