import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosion_str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= explosion_str.length()) {
                boolean check = true;

                for (int j = 0; j < explosion_str.length(); j++) {
                    if (stack.get(stack.size() - explosion_str.length() + j) != explosion_str.charAt(j)) {
                        check = false;
                        break;
                    }
                }

                if(check){
                    for (int j = 0; j < explosion_str.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            for(char c : stack) sb.append(c);
            System.out.print(sb);
        }else{
            System.out.print("FRULA");
        }
    }
}