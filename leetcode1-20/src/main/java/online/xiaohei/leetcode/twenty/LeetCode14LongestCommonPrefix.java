package online.xiaohei.leetcode.twenty;

import java.util.*;

public class LeetCode14LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LeetCode14LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            int strLen = str.length();
            minLen = strLen < minLen ? strLen : minLen;
        }

        // strs.length>1
        boolean eq;
        int maxIndex = 0;

        for (int index = 0; index < minLen; index++) {
            eq = true;
            // first str' char
            char curr = strs[0].charAt(index);
            // for each str' char
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != curr) {
                    eq = false;
                    break;
                }
            }
            if (!eq) {
                break;
            }
            maxIndex++;
        }
        return strs[0].substring(0, maxIndex);
    }
}
