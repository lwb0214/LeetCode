/***
*题目：获取给定字符串的最长回文子串
*做法：找到原串与反串的最长公共子串,并比较下标
*注意点：需要和原字符串对比位置
*时间复杂度：O(N^2) 空间复杂度：O(N)
*记录时间：2020/3/10
***/
   //动态规划 (获取最长回文串) 需要和原字符对比位置
     public String longestPalindrome(String s) {
		
		int len=s.length();
        if (len<=1) {
            return s;
        }

        String rs = new StringBuilder(s).reverse().toString();  //倒序

        int longestlength = 0;
        int maxEnd = 0;
        int[] temp = new int[s.length()];

        char[] s_char = s.toCharArray();
        char[] rs_char = rs.toCharArray();


        for (int i = 0; i < len; i++) {    //初始化第一行
            temp[i] = (s_char[0] == rs_char[i]) ? 1 : 0;
        }

        for (int i = 1; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {

                if (s_char[i] == rs_char[j]) {

                    if ( j == 0) {
                        temp[j] = 1;
                    } else {
                        temp[j] = temp[j - 1] + 1;
                    }

                    if (temp[j] > longestlength) {

                        /*******************增加的部分***********************/
                        int beforePos = len - j - 1;
                        if (beforePos + temp[j] - 1 == i) {
                            longestlength = temp[j];
                            maxEnd = i;
                        }
                    }
                } else {
                    temp[j] = 0;
                }
            }
        }
        return s.substring(maxEnd - longestlength + 1, maxEnd + 1);
    }
	
//法2：中心扩展
/***
*时间复杂度：O(N^2) 空间复杂度：O(1)
*注意点：返回长度以及初始位置的取值
***/
class Solution {
    public String longestPalindrome(String s) {
        int sLen=s.length();
        if(sLen<=1){
            return s;
        }
        
        int start=0,len=0;
        for(int i=0;i<sLen-1;i++){
            int Max=Math.max(getMaxLen(s,i,i),getMaxLen(s,i,i+1));

            if(Max>len){
                len=Max;
                start=i-(len-1)/2;
            }
        }
        return s.substring(start,start+len);
    }

    private int getMaxLen(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            --l;
            ++r;
        }
        return r-l-1;
    }
}