import java.util.Stack;
//不推荐使用stack
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int node;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                node=stack1.pop();
                stack2.push(node);
            }
        }
        node=stack2.pop();
        return node;
    }
}