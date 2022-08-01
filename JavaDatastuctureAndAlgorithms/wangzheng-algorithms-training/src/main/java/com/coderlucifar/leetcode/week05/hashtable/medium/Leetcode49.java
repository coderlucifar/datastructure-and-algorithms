package com.coderlucifar.leetcode.week05.hashtable.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode49: 字母异位词分组
 *      题目描述：给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *               字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 *      问题：
 *          题目提交之后，直接超时了！
 *          重点看下视频讲解和题解是如何降低时间复杂度的！！！
 *
 */
public class Leetcode49 {

    public static void main(String[] args) {
        Leetcode49 leetcode49 = new Leetcode49();
        Solution solution = leetcode49.new Solution();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
    }

    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null) return null;
            Map<String,List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String s = new String(chars);
                if (map.containsKey(s)) {
                    List<String> list = map.get(s);
                    list.add(str);
                } else {
                    map.put(s, new ArrayList<>(Arrays.asList(new String[]{str})));
                }
            }
            List<List<String>> list = map.values().stream().collect(Collectors.toList());
            return list;
        }

        /**
         * 用这个方法求解时间复杂度太高超时了
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams_method2(String[] strs) {
            //结果集
            List<List<String>> result = new ArrayList<>();
            //存储使用过的字符串，set中存储数组下标，因为可能有重复的字符串，但是下标不同。
            Map<String, Set<Integer>> usedMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                if (usedMap.containsKey(strs[i]) && usedMap.get(strs[i]).contains(i)) {
                    //说明这个字符串已经使用过了
                    continue;
                }
                String tmp = strs[i];
                List<String> list = new ArrayList<>();
                list.add(tmp);
                if (!usedMap.containsKey(tmp)) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    usedMap.put(tmp, set);
                } else {
                    Set<Integer> set = usedMap.get(tmp);
                    set.add(i);
                    usedMap.put(tmp, set);
                }
                for (int j = i+1; j < strs.length; j++) {
                    if (usedMap.containsKey(strs[j]) && usedMap.get(strs[j]).contains(j)) {
                        //如果当前字符已经被处理过，直接跳过
                        continue;
                    }
                    if (isAnagram(tmp,strs[j])) {
                        //如果为字母异位词
                        //添加到结果集
                        list.add(strs[j]);
                        if (!usedMap.containsKey(strs[j])) {
                            Set<Integer> set = new HashSet<>();
                            set.add(j);
                            usedMap.put(strs[j], set);
                        } else {
                            Set<Integer> set = usedMap.get(strs[j]);
                            set.add(j);
                            usedMap.put(strs[j], set);
                        }
                    }
                }
                result.add(list);
            }
            return result;
        }

        /**
         * 判断两个字符串是否是字母异味词
         * @param s
         * @param t
         * @return
         */
        private boolean isAnagram(String s, String t) {
            if (s == null || t == null) return false;
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();
            if (s1.length != s2.length) return false;
            Map<Character,Integer> map = new HashMap<>();
            for (char c : s1) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                }
            }
            for (char c : s2) {
                if (map.containsKey(c)) {
                    if (map.get(c) > 1) {
                        map.put(c, map.get(c)-1);
                    } else {
                        map.remove(c);
                    }
                } else {
                    return false;
                }
            }
            if (map.isEmpty()) return true;
            return false;
        }
    }
}
