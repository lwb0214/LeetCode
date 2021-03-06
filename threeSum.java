/***
*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
*使得 a + b + c = 0  请你找出所有满足条件且不重复的三元组。
*时间复杂度：O(N^2)
***/
/***
*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
*使得 a + b + c = 0  请你找出所有满足条件且不重复的三元组。
*时间复杂度：O(N^2)
***/
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len - 2; ++i) {
			//之后就不再有可能出现符合条件的list了
            if (nums[i] > 0) {
                return lists;
            } 
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } 
            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    lists.add(Arrays.asList(curr, nums[L], nums[R]));
                    while (L < R && nums[L + 1] == nums[L]) {
                        ++L;
                    } 
                    while (L < R && nums[R - 1] == nums[R]) {
                        --R;
                    } 
                    ++L;
                    --R;
                } else if (tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

}