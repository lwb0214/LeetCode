/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，
 * 11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 */

class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int res = 1, pre = 1, len = s.length();
        for (int i = 2; i <= len; i++) {
            String tmp = s.substring(i - 2, i);
            int cur = tmp.compareTo("10") >= 0 && 
                    tmp.compareTo("25") <= 0 ? res + pre : res;
            pre = res;
            res = cur;
        } 
        return res; 
    }
}
