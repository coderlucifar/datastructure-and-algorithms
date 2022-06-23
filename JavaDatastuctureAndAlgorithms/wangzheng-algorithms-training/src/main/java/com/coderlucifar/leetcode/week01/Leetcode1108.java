package com.coderlucifar.leetcode.week01;

/**
 * leetcode1108: IP地址无效化
 */
public class Leetcode1108 {

    class Solution {
        public String defangIPaddr(String address) {
            char[] chars = address.toCharArray();
            char[] resChar = new char[chars.length + 6];
            int temp = 0;
            for (int i = 0; i < chars.length; i++) {
                if (!".".equals(chars[i] + "")) {
                    resChar[temp] = chars[i];
                    temp++;
                } else {
                    resChar[temp] = '[';
                    temp = temp + 1;
                    resChar[temp] = chars[i];
                    temp = temp + 1;
                    resChar[temp] = ']';
                    temp++;
                }
            }
            String s = new String(resChar);
            return s;
        }
    }

    public static void main(String[] args) {
        Leetcode1108 leetcode1108 = new Leetcode1108();
        Solution solution = leetcode1108.new Solution();
        String address = "255.100.50.0";
        String result = solution.defangIPaddr(address);
        System.out.println(result);
    }
}
