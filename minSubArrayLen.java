/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1, len = nums.length;
        int left = 0, right = 0, sum = 0;
        while (right < len) {
            while (right < len && sum < s) {
                sum += nums[right];
                right++;
            }
            while (left < right && sum >= s) {
                sum -= nums[left];
                left++;
            }
            min = Math.min(right - left + 1, min);
        }
        return min != nums.length + 1 ? min : 0;
    }
    
}