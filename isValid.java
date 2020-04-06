/***
*
*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
*有效字符串需满足：
***1.左括号必须用相同类型的右括号闭合。
***2.左括号必须以正确的顺序闭合。
*注意空字符串可被认为是有效字符串。
*
***/
class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        char[] ca=s.toCharArray();
        Deque<Character> stack=new LinkedList<Character>();
        for(char c:ca){ //使用push、peek、pop方法也可
            if(c=='(' || c=='[' || c=='{'){
                stack.addFirst(c);
            }
            else if(stack.isEmpty()){ //如果无法进行配对
                return false;
            }
            else{ //栈非空且则进行配对
                if(c==')' && stack.peekFirst()=='('){
                    stack.removeFirst();
                }
                else if(c==']' && stack.peekFirst()=='['){
                    stack.removeFirst();
                }
                else if(c=='}' && stack.peekFirst()=='{'){
                    stack.removeFirst();
                }
                else{//配对失败
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}