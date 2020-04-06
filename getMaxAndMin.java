/*给你N个数字，得到组合后最大和最小的一个数

283，192，892，3，31，23，22，5，41，888，979


*/

public class Main {
	public static void main(String[] args) {
	int[] nums=new int[] {283,192,892,3,31,22,221,5,41,888,979};
	getMinAndMax(nums);
	}


public static void getMinAndMax(int[] nums){
	String res1="",res2="";
	bubbleSort(nums);
	for(int i=0;i<nums.length;i++) {
		res1=res1+String.valueOf(nums[i])+" ";
	}
	System.out.println(res1);
	for(int i=nums.length-1;i>=0;i--) {
		res2=res2+String.valueOf(nums[i])+" ";
	}
	System.out.println(res2);
}
public static void bubbleSort(int[] ns) {
	int sortBorder=ns.length-1,lastExIndex=0;
	for(int i=0;i<ns.length-1;i++){
		boolean isSorted=true;
		
        for(int j=0;j<sortBorder;j++){
        	String t1=String.valueOf(ns[j]);
            String t2=String.valueOf(ns[j+1]);
            if(t1.compareTo(t2)<=-1){
            	if(  t1.length()<t2.length() && 
            	   t1.equals( t2.substring(0, t1.length()) )  ){}
            	else {
            		int t=ns[j];
            		ns[j]=ns[j+1];
            		ns[j+1]=t;
            		isSorted=false;
            		lastExIndex=j;
            	}
             }
        }
        if(isSorted) {
        	break;
        }
        sortBorder=lastExIndex;
    }
}

	
}