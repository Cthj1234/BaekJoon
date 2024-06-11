import java.util.Stack;

class Solution {
    public int solution(int[] orders){

        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for (int i = 1; i <= orders.length; i++) {
            stack.push(i);
            while(!stack.isEmpty()){
                if (stack.peek() == orders[idx]) {
                    stack.pop();
                    idx++;
                    answer++;
                }else{
                    break;
                }
            }
        }

        return answer;
    }
}