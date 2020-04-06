//解法一：小根堆（优先队列）
class Solution {
    public int findKthLargest(int[] nums, int k) {
		//优先队列是小顶堆（队头元素最小）
        PriorityQueue<Integer> queue=new PriorityQueue<>();   
        for(int num:nums){								
            queue.offer(num);	
            if(queue.size()>k){		//最小的出队，最后留下K个最大的
                queue.poll();
            }
        }
        return queue.peek();	//队头为第K大的元素
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left=0,right=nums.length-1;
        int tar=nums.length-k;

        while(true){
            int index=partion(nums,left,right);
            if(index==tar){
                return nums[index];
            }
            else if(index<tar){
                left=index+1;
            }
            else{
                right=index-1;
            }
        }
    }
    private int partion(int[] nums, int left, int right){
        int pivot=nums[left];
        while(left<right){
             while(left<right && nums[right]>pivot){    //注意要先right--
                right--;                      //因为nums[left]已经取出作为pivot
            }
            if(left<right){     
                nums[left]=nums[right];
                left++;
            }
            while(left<right && nums[left]<=pivot){
                left++;
            }
            if(left<right){
                nums[right]=nums[left];
                right--;
            }
        }
        nums[left]=pivot;	//此时left==right
							
        return left;	
    }
}

