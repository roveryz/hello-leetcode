package online.xiaohei.leetcode.twenty;

import java.util.HashMap;

public class LeetCode1TwoSum {

    public static void main(String[] args) {

    }


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int maxLen = nums.length;
            for (int i = 0; i < maxLen - 1; i++) {
                for (int j = i + 1; j < maxLen; j++) {
                    if (target == (nums[i] + nums[j])) {
                        int[] result = new int[2];
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return null;
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int maxLen = nums.length;
            // <key=target-itemValue, value=itemIndex>
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < maxLen; i++) {
                int currentValue = nums[i];
                int currentIndex = i;
                // currentValue == target-itemValue
                if (hashMap.containsKey(currentValue)) {
                    int[] result = new int[2];
                    result[0] = hashMap.get(currentValue);
                    result[1] = currentIndex;
                    return result;
                } else {
                    hashMap.put(target - currentValue, currentIndex);
                }
            }
            return null;
        }
    }
}

