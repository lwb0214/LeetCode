/*
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
class Solution {
    public boolean validPalindrome(String s) {
        int[] idx = isPalindrome(s, 0, s.length() - 1);
        return idx[0] == -1 ? true : isPalindrome(s, idx[0] + 1, idx[1])[0] == -1
            || isPalindrome(s, idx[0], idx[1] - 1)[0] == -1;
    }
    private int[] isPalindrome(String s, int start, int end) {
        int[] res = new int[] {-1, -1};
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                res[0] = start;
                res[1] = end;
                return res;
            }
            start++;
            end--;
        }
        return res;
    }
}