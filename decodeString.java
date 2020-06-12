/**
 * 腾讯后台笔试题（类似）
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，
 * 例如不会出现像 3a 或 2[4] 的输入。
 */
class Solution {
    public String decodeString(String s) {
        //由内向外--后进先出，故使用栈（双向队列）
        Deque<String> stack_str = new LinkedList<>();
        Deque<Integer> stack_mul = new LinkedList<>();
        int mul = 0;
        String res = "";
        char[] ca = s.toCharArray();

        //如a3[c]
        for (char c: ca) {
            if (c >= '0' && c <= '9') {
                mul = 10 * mul + (c - '0');
            } else if (c == '[') {
                stack_mul.push(mul);
                stack_str.push(res);
                mul = 0;
                res = "";
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(stack_str.pop());
                int repeat = stack_mul.pop();
                while (repeat > 0) {
                    sb.append(res);
                    repeat--;
                }
                res = sb.toString();
            } else {
                res += String.valueOf(c);
            }
        }

        return res;
    }
}