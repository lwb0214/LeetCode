/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //对短的数组二分
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int k = (n1 + n2 + 1) >>> 1;
        int left = 0;
        int right = n1;
        while (left < right) {
            int m1 = (left + right) >>> 1;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                left = m1 + 1;
            else
                right = m1;
        }
        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                         m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if (((n1 + n2) & 1) == 1)
            return c1;
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE :nums1[m1],
                         m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
        
    }
}