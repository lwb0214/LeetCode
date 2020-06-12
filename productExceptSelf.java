/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 不能使用除法
 */

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }
	
}
