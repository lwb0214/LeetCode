class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        
        if(len2<len1){  //对短的数组二分
            int[] temp=nums2;
            nums2=nums1;
            nums1=temp;
            len1=nums1.length;		//数组交换后要更新长度
            len2=nums2.length;
        }
        int half=(len1+len2+1)/2;
        boolean even=((len1+len2)%2)==0?true:false;

        int start=0,end=len1,apart=0,bpart=0;
        //目标：使nums1[apart-1]<=nums2[bpart]且nums2[bpart-1]<=nums1[apart]
        while(start<=end){
            apart=(start+end)/2;    //二分法，aprt的值=数组1apart左侧元素个数
            bpart=half-apart;
            if(apart>start && nums1[apart-1]>nums2[bpart]){
                end=apart-1;
            }
            else if(apart<end && nums1[apart]<nums2[bpart-1]){
                start=apart+1;
            }
            else{
                double leftMax=0;
                if(apart==0){ //数组1中最小的元素都比bpart左侧最大元素大
                    leftMax=nums2[bpart-1];
                }
                else if(bpart==0){ //数组2中最小的元素都比apart左侧最大元素大
                    leftMax=nums1[apart-1];
                }
                else{
                    leftMax=Math.max(nums1[apart-1],nums2[bpart-1]);
                }
                if(!even){
                    return leftMax;
                }

                double minRight=0;
                if(apart==len1){
                    minRight=nums2[bpart];
                }
                else if(bpart==len2){
                    minRight=nums1[apart];
                }
                else{
                    minRight=Math.min(nums2[bpart],nums1[apart]);
                }
                return (leftMax+minRight)/2.0;
            }
        }
        return -1.0;
    } 
}

