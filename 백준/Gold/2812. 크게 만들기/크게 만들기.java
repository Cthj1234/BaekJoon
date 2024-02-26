import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int len = N - K;
        String num = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int tmp = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (!stack.isEmpty()) {
                if (tmp >= stack.peek()) {
                    while (true) {
                        if (stack.isEmpty() || K == 0 || stack.peek() >= tmp) break;
                        stack.pop();
                        K--;
                    }
                    stack.push(tmp);
                } else stack.push(tmp);
            } else stack.push(tmp);
        }
        while(true){
            if (stack.size() == len) break;
            stack.pop();
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.print(sb.reverse());
    }
}