/***
*动态规划解决字符串匹配问题
*时间复杂度：O(MN) 空间复杂度：O(MN)
***/
//"*a"可表示""、"a"、"aa"…… 	"."可表示任意字符
public boolean isMatch(String s, String p) {
    int sLen=s.length(),pLen=p.length();
    boolean[][] dp=new boolean[pLen+1][sLen+1]; //dp[i][j]:p[1~i]与s[1~j]是否匹配,
												//默认为false

    dp[0][0]=true; //初始化第一行
    //初始化第一列
    for(int i=1;i<=pLen;i++){
       if(p.charAt(i-1)=='*'){
           dp[i][0]=dp[i-2][0];
       }
    }

    for(int si=1;si<=sLen;si++){
        for(int pi=1;pi<=pLen;pi++){
            if(p.charAt(pi-1)=='.' || p.charAt(pi-1)==s.charAt(si-1)){
                dp[pi][si]=dp[pi-1][si-1];
            }
            else if(p.charAt(pi-1)=='*'){
                if(p.charAt(pi-2)==s.charAt(si-1) || p.charAt(pi-2)=='.'){
                    dp[pi][si]= dp[pi-2][si] || dp[pi][si-1];
                }
                else{
                    dp[pi][si]=dp[pi-2][si];
                }
            }
        }
    }
    return dp[pLen][sLen];
}