//判断一个整数是否是回文数
class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
          return false;
      }
      String s=String.valueOf(x);
      int left=0,right=s.length()-1;
      while(left<right){
          if(s.charAt(left)!=s.charAt(right)){
              return false;
          }
          left++;
          right--;
      }
      return true;
}
}