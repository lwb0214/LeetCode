/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
*/
//二分法
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left <= right) {
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int)right;
    }
}