/***
*
*根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
*如果之后都不会升高，请在该位置用 0 来代替。
*
*例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
*你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
*
***/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length]; //初值为0
        Deque<Integer> stack = new LinkedList<>();  //递减栈（存的是下标）
        for (int i = 0; i <T.length; i++) {
            //非递减时更新ans
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]){
                ans[stack.peekFirst()]=i-stack.peekFirst();
                stack.removeFirst();
            }
            //递减时入栈
            stack.addFirst(i);
        }
        return ans;
    }
}