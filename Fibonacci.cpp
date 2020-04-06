public class Solution {
	//小青蛙跳台阶、堆箱子问题（j=2）
	public int getFibN(int n){
		if(n==1||n==2)
			return 1;
		int x,FibN;
		int i=1,j=1;
		for(x=3;x<=n;x++)
		{
			FibN=i+j;
			i=j;
			j=N;	//i、j后移
		}
		return FibN;
	}
	//跳台阶变式
    public int JumpFloorII(int target) {
        int fn=1;
        if(target==1)
            return fn;
        for(int i=2; i<=target; i++){
            fn=2*fn;
        }
        return fn;
    }
}