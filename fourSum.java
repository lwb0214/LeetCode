import java.util.List;
import java.util.ArrayList;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 */

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4)
            return lists;

        for (int a = 0; a <= nums.length - 4; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int b = a + 1; b <= nums.length - 3; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        lists.add(Arrays.asList(nums[a], nums[b], 
                                nums[c], nums[d]));
                        while (c < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }

}