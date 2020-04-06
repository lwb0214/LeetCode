/***
*时间复杂度O(N)
*空间复杂度O(N)
***/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        if(nums==null||nums.length==1) {
            return null;
        }
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int tar=target-nums[i];
            if(m.containsKey(tar)){
                res[0]=i;
                res[1]=m.get(tar);
                return res;
            }
            else{
                m.put(nums[i],i);
            }
        }
        return res;
    }
}