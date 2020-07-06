/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 */
//滑动窗口经典题
class Solution {
	
    public String minWindow(String s, String t) {
        int[] needs = new int[58];
        for (char c: t.toCharArray()) {
            needs[c - 65]++;
        }
        int size = 0;
        for (int i = 0; i <= 57; i++) {
            if (needs[i] != 0) 
                size++;
        }

        int[] window = new int[58];
        int match = 0, min = Integer.MAX_VALUE, start = 0;
        int sLen = s.length(), left = 0, right = 0;
        while (right < sLen) {
            int ch1 = s.charAt(right) - 65;
            if (needs[ch1] != 0) {
                window[ch1]++;
                if (needs[ch1] == window[ch1]) {
                    match++;
                }
            }
            right++;
            while (match == size) {
                if ((right - left) < min) {
                    start = left;
                    min = right - left;
                }
                int ch2 = s.charAt(left) - 65;
                if (needs[ch2] != 0) {
                    window[ch2]--;
                    if (window[ch2] < needs[ch2]) {
                        match--;
                    }
                }
                left++;
            }
        }

        return min != Integer.MAX_VALUE ? s.substring(start, start + min) : "";
    }
	
}