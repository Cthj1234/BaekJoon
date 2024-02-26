import java.util.Scanner;
import java.util.Stack;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String input = sc.nextLine();
        int answer = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
                if(!stack.isEmpty()) {
                    answer += stack.size();
                    i++;
                }
            }else if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                answer ++;
            }
            else if(!stack.isEmpty() && input.charAt(i) == ')') stack.pop();
        }
        System.out.println(answer);
    }
}