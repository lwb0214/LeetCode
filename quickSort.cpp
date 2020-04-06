void quickSort(int s[],int l,int r)
{
	if(l<r){
		int i=l,j=r,x=s[l];		//x存储基准数
		while(i<j){
		
			while(i<j&&s[j]>=x)	j--;
			if(i<j)	s[i++]=s[j];
			
			while(i<j&&s[i]<x)	i++;
			if(i<j)	s[j--]=s[i];

		}
		s[i]=x;	//左边比s[i]小，右边比s[i]大
		//分治法
		quickSort(s,l,i-1);	//直到区间只有一个数
		quickSort(s,i+1,r);
		
	}
}