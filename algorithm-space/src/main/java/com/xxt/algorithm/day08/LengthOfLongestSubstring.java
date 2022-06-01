package com.xxt.algorithm.day08;

import java.util.HashSet;
import java.util.Set;

/**
 * 不重复的最长字符串子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSequenceSet = new HashSet<>();
        int rk = -1;
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            //删除起始节点
            if (i != 0) {
                charSequenceSet.remove(s.charAt(i - 1));
            }
            //不断的向右移动rk，直到set已经存在该元素
            while (rk + 1 < s.length() && !charSequenceSet.contains(s.charAt(rk + 1))) {
                charSequenceSet.add(s.charAt(rk + 1));
                rk++;
            }
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }

}
