/**
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
* ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
* 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
* 你可以假设数组中不存在重复的元素。
* 你的算法时间复杂度必须是 O(log n) 级别。
*/
//二分法
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return mid;
            //mid落在左半边
            if (nums[mid] >= nums[lo]) {
                //target在mid左边
                if (nums[lo] <= target && nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }   
        }
        return -1;
    }
}