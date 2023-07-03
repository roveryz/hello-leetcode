package online.xiaohei.leetcode.twenty;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13Roman2Integer {

    public static void main(String[] args) {
        System.out.println(new LeetCode13Roman2Integer().romanToInt("MCMXCIV"));
    }


    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;
        int pre = 0;
        int[] re = new int[s.length()];
        int index = 0;
        for (char i : s.toCharArray()) {
            if (!map.containsKey(i)) {
                return 0;
            }
            int curr = map.get(i);
            if (index == 0) {
                re[index] = curr;
                pre = curr;
                index++;
                continue;
            }
            // left > right, need left+right, i will add them in the end, so here just set value into arr
            if (curr <= pre) {
                re[index] = curr;
            } else {
                // right>left
                re[index - 1] = 0;
                re[index] = curr - pre;
            }
            pre = curr;
            index++;
        }

        for (int i : re) {
            result += i;
        }

        return result;
    }

    public int romanToInt2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int re = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (!map.containsKey(s.charAt(i)) || !map.containsKey(s.charAt(i + 1))) {
                return 0;
            }
            int curr = map.get(s.charAt(i));
            int right = map.get(s.charAt(i + 1));
            if (right > curr) {
                re -= curr;
            } else {
                re += curr;
            }
        }
        if (!map.containsKey(s.charAt(s.length() - 1))) {
            return 0;
        }
        re += map.get(s.charAt(s.length() - 1));
        return re;

    }

}
