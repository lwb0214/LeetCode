	public static void main(String[] args) {
		int[] ns = { 25,24,19,23,22 };
		//改进版冒泡排序
		int sortBorder=ns.length-1,lastExIndex=0;
		for(int i=0;i<ns.length-1;i++){
			boolean isSorted=true;
	        for(int j=0;j<sortBorder;j++){
	            if(ns[j]<ns[j+1]){
	                int t=ns[j];
	                ns[j]=ns[j+1];
	                ns[j+1]=t;
	                isSorted=false;
	                lastExIndex=j;
	             }
	        }
	        if(isSorted==true) {
	        	break;
	        }
	        sortBorder=lastExIndex;
	    }
		System.out.println(Arrays.toString(ns));
	}