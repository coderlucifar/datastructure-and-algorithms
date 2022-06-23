package com.coderlucifar.leetcode.week01;

/**
 * 剑指Offer67：把字符串转换成整数。
 *      1、首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 *      2、当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
 *      作为该整数的正负号； 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 *      3、该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数
 *      不应该造成影响。
 *
 *      4、注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅仅
 *      包含空白字符时，则你的函数不需要进行转换。
 *
 *     在任何情况下，若函数不能进行有效的转换时，请返回0。
 */
public class SwordToOffer67 {

    class Solution{
        public int strToInt(String str) {
            final int Int_MAX = ((int)((long) (2<<30) - 1));
            if (str == null) return 0;
            if ("".equals(str)) return 0;
            char[] chars = str.toCharArray();
            int n = chars.length;
            int i = 0;
            long sum = 0;
            int temp = 0;
            int zeroNum = 0;
            boolean moreThanZero = true;
            //循环
            while (i < n){
                //跳过字符数组中的前置空格
                if ((chars[i] == ' ')) {
                    i++;
                } else if ((chars[i] == '0')){
                    zeroNum++;
                    i++;
                    if (i < n) {
                        if (!isAlpha(chars[i]))
                        return 0;
                    }
                } else {
                    break;
                }
            }

            //如果去除掉前置的空字符和0之后
            // 已经越界，返回0
            if (i >= n) {
                return 0;
            }
            //不是数字字符或正负号，返回0
            if (!isAlpha(chars[i]) && (chars[i] != '-') && (chars[i] != '+')) {
                return 0;
            }

            //程序走到这里，说明下面的 chars[i] 一定是 '1'-'9'之间的字符或者 '+' 或者 '-'
            if (!isAlpha(chars[i])) {
                //如果是符号
                //只要前面出现过连续的'0'就return 0
                if (zeroNum > 0) return 0;
                //前面没出现过'0'
                else {
                    //保存符号，指针前移
                    if (chars[i] == '-') {
                        moreThanZero = false;
                    } else {
                        moreThanZero = true;
                    }
                    i++;
                }
            }
            //程序执行到这里如果说明存在符号！
            //找到第一个符号后判断数组是否越界
            //越界返回零
            if (i >= n) return 0;
            //不是数字字符返回0
            if (!isAlpha(chars[i])) return 0;


            //程序执行到这里说明当前指针指向的一定是数字字符
            //把前至的'0'都跳过
            while (chars[i] == '0') {
                i++;
            }
            //前置'0'跳过后判断数组是否越界
            if (i >= n) return 0;
            //判断跳过'0'后是否紧跟着的是数字字符，不是数字字符返回0
            if (!isAlpha(chars[i])) return 0;

            //程序如果能走到这里，说明找到了第一个非0数字字符
            for (int j = i; j < n; j++) {
                if (isAlpha(chars[j])) {
                    temp = chars[j] - '0';
                    sum = sum * 10 + temp;
                    if (moreThanZero && (sum >= Int_MAX)) return Int_MAX;
                    if (!moreThanZero && (sum > Int_MAX)) return (2<<30);
                } else {
                    break;
                }
            }
            if (moreThanZero) return (int) sum;
            else return (int) (-sum);

        }

        /**
         * 判断c是否在 '0' 到 '9' 之间
         * @param c
         * @return
         */
        private boolean isAlpha(char c) {
            if (c >= '0' && c <= '9') return true;
            return false;
        }


    }

    public static void main(String[] args) {
        SwordToOffer67 swordToOffer67 = new SwordToOffer67();
        Solution solution = swordToOffer67.new Solution();
        String str = "-2147483647";
        String str1 = "9223372036854775808";
        String str2 = "0-1";
        String str3 = "  0000000000012345678";
        int i = solution.strToInt(str3);
        System.out.println(i);
//        System.out.println((int) (-(long)(2<<30)));
//        System.out.println((int)((long) (2<<30) - 1));
//        System.out.println(2<<30);
    }

}
