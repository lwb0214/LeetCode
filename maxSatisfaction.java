/**
* 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
* 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，
* 也就是 time[i]*satisfaction[i] 。
*
*请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
*你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
*
*示例 1：
*
*输入：satisfaction = [-1,-8,0,5,-9]
*输出：14
*解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。
*每道菜都需要花费 1 单位时间完成。
*
*/
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int len=satisfaction.length;
        Arrays.sort(satisfaction);
        int sum=0;
		//妙啊
		/* int res=0;
		for(int i=len-1; i>=0; i--) {
            sum += satisfaction[i];
            if(sum<0) break;
            res += sum;
        } */
        for(int i=0; i<len; i++) {
            sum+=satisfaction[i];
        }
        int[] dec = new int[len];
        dec[0]=sum;
        for(int j=1; j<len; j++) {
            dec[j] = dec[j-1] -satisfaction[j-1];
        }
        sum=0;
        for(int m=0; m<len; m++) {
            sum = sum + (m+1)*satisfaction[m];
        }
        int res=sum;
        for(int k=0; k<len; k++) {
            sum = sum - dec[k];
            res = Math.max(res,sum);
        }
        return res;
    }
}