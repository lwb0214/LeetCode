//ZigZag convert
class Solution {
    public String convert(String s, int numRows) {
        char[] c=s.toCharArray();
        StringBuilder[] sb=new StringBuilder[numRows];
        int len=c.length,sbLen=sb.length;

        for(int i=0;i<sbLen;i++){
            sb[i]=new StringBuilder();
        }

        int i=0;
        while(i<len){
            for(int idx=0;idx<numRows && i<len; idx++){
                sb[idx].append(c[i++]);
            }

            for(int idx=numRows-2;idx>=1 && i<len; idx--){
                sb[idx].append(c[i++]);
            }
        }

        for(int idx=1;idx < sbLen;idx++){
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}