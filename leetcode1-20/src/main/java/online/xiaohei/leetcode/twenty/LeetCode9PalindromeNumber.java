package online.xiaohei.leetcode.twenty;

public class LeetCode9PalindromeNumber {

    public static void main(String[] args) {


        System.out.println(LeetCode9PalindromeNumber.Solution3.isPalindrome(1011));
    }

    static class Solution3 {
        public static boolean isPalindrome(int x) {
            // minus must not
            if (x < 0) {
                return false;
            }
            // 0 to 9 is palindrome
            if (x >= 0 && x < 10) {
                return true;
            }

            // last is 0, must false
            if (x % 10 == 0) {
                return false;
            }

            int reverse = 0;

            while (x >= reverse) {
                if (x == reverse) {
                    return true;
                }
                int last = x % 10;
                x /= 10;

                reverse *= 10;
                reverse += last;

            }
            if (reverse / 10 == x) {
                return true;
            }
            return false;
        }
    }

    static class Solution2 {
        public static boolean isPalindrome(int x) {
            // minus must not
            if (x < 0) {
                return false;
            }
            // 0 to 9 is palindrome
            if (x >= 0 && x < 10) {
                return true;
            }

            // last is 0, must false
            if (x % 10 == 0) {
                return false;
            }

            // 数组
            int maxLen = 0;
            int[] origin = new int[20];
            while (true) {
                int last = x % 10;
                x = x / 10;
                if (last == 0 && x == 0) {
                    break;
                }
                origin[maxLen] = last;
                maxLen++;
            }
            for (int i = 0; i < maxLen; i++) {
                if (origin[i] != origin[maxLen - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution1 {
        public boolean isPalindrome(int x) {
            // minus must not
            if (x < 0) {
                return false;
            }
            // 0 to 9 is palindrome
            if (x >= 0 && x < 10) {
                return true;
            }
            // to string
            String xStr = String.valueOf(x);
            // 奇书是向下取整
            for (int i = 0; i < xStr.length() / 2; i++) {
                if (xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
