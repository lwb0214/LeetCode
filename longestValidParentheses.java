/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 注意：子串的含义
 */
class Solution {

    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        s = " " + s;
        int dp[] = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    
}