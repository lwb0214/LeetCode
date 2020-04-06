//将字符串转换成整数
class Solution {
    public int myAtoi(String str) {
        char[] c=str.trim().toCharArray();
        int len=c.length;
        if(len==0){
            return 0;
        }
        int i=0;
        boolean flag=true;
        if(c[i]=='+'){
            i++;
        }
        else if(c[i]=='-'){
            i++;
            flag=false;
        }
        long result=0;
        while(i<len && Character.isDigit(c[i])){
            result=result*10+(c[i]-'0');
            if(flag){
                if(result>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }
            else{
                if(-result<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                }
            i++; 
        }
        if(!flag){
            result=-result;
        }
        return (int)result;
    }
}