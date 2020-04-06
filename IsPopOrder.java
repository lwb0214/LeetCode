import java.util.LinkedList;
import java.util.Deque;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
         if(pushA.length == 0 || popA.length == 0)
             return false;
         Deque<Integer> s = new LinkedList<Integer>();
         //用于标识弹出序列的位置
         int popIndex = 0;
         for(int i = 0; i< pushA.length;i++){
             s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.isEmpty() && s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
             }
         }
         return s.isEmpty();
    }
}