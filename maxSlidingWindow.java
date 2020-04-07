/***

*给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
*你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

*返回滑动窗口中的最大值。

***/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        int len=nums.length;
        if(k==0 || len==0) return null;
        
        //第一个窗口
        for(int i=0; i<k; i++) {
            while (!window.isEmpty() && nums[i]>nums[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(i);
        }
        res.add(nums[window.peekFirst()]);

        for(int i=k; i<len; i++) {
            //若本窗口不包含上一个窗口的最大值对应的下标，则将其移除
            if(!window.isEmpty() && window.peekFirst()<=i-k) {
                window.removeFirst();
            }
            while(!window.isEmpty() && nums[i] > nums[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(i);
            res.add(nums[window.peekFirst()]);
        }
		
		//不能直接转换的悲伤
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
		
        return ans;
    }
}