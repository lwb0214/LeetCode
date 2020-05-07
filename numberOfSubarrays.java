/**
*给你一个整数数组 nums 和一个整数 k。
*如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
*请返回这个数组中「优美子数组」的数目。

*示例 1：

*输入：nums = [1,1,2,1,1], k = 3
*输出：2
*解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
*/
//双指针（囧穷举法）
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, res = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if ((nums[i] & 1)==1) {
                index.add(i);
            }
        }
        int left = 0, right = k-1;
        int max = index.size();
        while (right < max) {
            int firstOdd = index.get(left), lastOdd = index.get(right);
            if (left==0 && (right+1)<max) {
                int nextOdd = index.get(right+1);
                res = res + (firstOdd+1)*(nextOdd-lastOdd);
                left++;
                right++;
            } else if (left==0 && (right+1)==max) {
                res = res + (firstOdd+1)*(len-lastOdd);
                right++;
            } else if (left>0 && (right+1)<max) {
                int preOdd = index.get(left-1);
                int nextOdd = index.get(right+1);
                res = res + (firstOdd-preOdd)*(nextOdd-lastOdd);
                left++;
                right++;
            } else if (left>0 && (right+1)==max) {
                int preOdd = index.get(left-1);
                res = res + (firstOdd-preOdd)*(len-lastOdd);
                right++;
            }
        }
        return res;
    }
}
//改进版
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, res = 0;
        ArrayList<Integer> index = new ArrayList<>();
        index.add(-1);
        for(int i = 0; i < len; i++) {
            if ((nums[i] & 1)==1) {
                index.add(i);
            }
        }
        index.add(len);
        int max = index.size();
        for (int left=1, right=k; right < max-1; left++,right++) {
            res += (index.get(left)-index.get(left-1))
                *(index.get(right+1)-index.get(right));
        }
        return res;
    }
}