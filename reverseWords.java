
//给定一个字符串，逐个翻转字符串中的每个单词。
class Solution {
    public String reverseWords(String s) {
        if(s==null || s.equals("")) return "";
        StringBuilder sb=new StringBuilder();
        char[] cs=s.toCharArray();
        int len=cs.length,i=len-1;

        while(i>=0){
            while(i>=0 && cs[i]==' ') i--;
            int end=i+1;
            while(i>=0 && cs[i]!=' ') i--;
            sb.append(s.substring(i+1,end));
            sb.append(" ");
        }
        
        return trimEnd(sb.toString());
    }
    public String trimEnd(String value) {
        char[] cs=value.toCharArray();
        int len = cs.length;

        while (len>=1 && cs[len - 1] == ' ') len--;

        return new String(cs).substring(0,len);
    }

}