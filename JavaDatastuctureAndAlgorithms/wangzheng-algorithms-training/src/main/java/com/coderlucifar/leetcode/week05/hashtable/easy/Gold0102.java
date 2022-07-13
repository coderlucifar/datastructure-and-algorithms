package com.coderlucifar.leetcode.week05.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Gold0102：判定是否互为字符重排
 */
public class Gold0102 {
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            //判空操作
            if(s1 == null || s2 == null) return false;
            //字符串转字符数组
            char[] arrs1 = s1.toCharArray();
            char[] arrs2 = s2.toCharArray();
            //如果两个数组长度不相等可以直接得到结果
            if(arrs1.length != arrs2.length) return false;
            //申请一个字典
            Map<Character,Integer> map = new HashMap();
            //遍历其中一个数组，把元素放入map，相同元素个数加一
            for(int i = 0; i < arrs1.length; i++) {
                if(!map.containsKey(arrs1[i])) {
                    map.put(arrs1[i], 1);
                } else {
                    map.put(arrs1[i], map.get(arrs1[i])+1);
                }
            }
            //遍历另一个数组
            for(int j = 0; j < arrs2.length; j++) {
                //如果map中包含当前元素
                if(map.containsKey(arrs2[j])) {
                    int tmp = map.get(arrs2[j]);
                    if(tmp > 0){
                        //如果当前元素在map中value的值大于0，值减1，代表抵消一个
                        tmp--;
                        //如果抵消后，value的值仍大于0，说明还没用完
                        if(tmp > 0) {
                            map.put(arrs2[j], tmp);
                        } else {
                            //否则代表用完，移除出字典
                            map.remove(arrs2[j]);
                        }
                    }
                } else {
                    return false;
                }
            }
            //循环结束后如果map为空，说明两个数组完全抵消，否则返回false，不满足题意
            if(map.entrySet().size() != 0) return false;
            return true;
        }
    }
    public static void main(String[] args) {

    }
}
