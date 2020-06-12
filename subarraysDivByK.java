/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0, counter = 0;
        int[] remainders = new int[K];
        //本身就可被整除的情况
        remainders[0] = 1;

        for (int a: A) {
            sum += a;
            int remainder = Math.floorMod(sum, K);
            counter += remainders[remainder];
            remainders[remainder]++;
        }

        return counter;
    }
}