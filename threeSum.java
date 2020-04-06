/***
*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
*使得 a + b + c = 0  请你找出所有满足条件且不重复的三元组。
*时间复杂度：O(N^2)
***/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i=0,n=nums.length;
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        while(i < n-2){
            int base=nums[i];
            int left=i+1;
            int right=n-1;

            while(left<right){
                int sum=base+nums[left]+nums[right];
                if(sum==0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left=moveRight(nums,left+1);
                    right=moveLeft(nums,right-1);
                }
                else if(sum>0){
                    right=moveLeft(nums,right-1);
                }
                else{
                    left=moveRight(nums,left+1);
                }
            }
            i=moveRight(nums,i+1);
        }
        return res;
    }

    public int moveLeft(int[] nums,int right){
        while(right== nums.length-1 || (right>=0 && nums[right]==nums[right+1])){
            right--;
        }
        return right; 
    }

     public int moveRight(int[] nums,int left){
        while(left<nums.length && nums[left]==nums[left-1]){
            left++;
        }
        return left; 
    }

}