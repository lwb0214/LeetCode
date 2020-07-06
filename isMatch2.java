/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 */
class Solution {

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            } else {
                dp[0][i] = true;
            }
        }
        
        // 要注意'?'不能匹配空字符
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if ((dp[i - 1][j] || dp[i][j - 1])
                    && p.charAt(j - 1) == '*') {
                        dp[i][j] = true;
                } else if (dp[i - 1][j - 1] && 
                            (p.charAt(j - 1) == '?' ||
                            p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = true;
                }
            }
        }
            
        return dp[sLen][pLen];
    }

}