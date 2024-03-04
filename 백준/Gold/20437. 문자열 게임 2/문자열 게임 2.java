import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer , answer2;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            boolean check = false;
            answer = Integer.MAX_VALUE;
            answer2 = -1;
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if(K == 1) {
                sb.append("1 1\n");
                continue;
            }
            HashMap<Character, Integer> num = new HashMap<>();
            HashMap<Character, Integer> first_point = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!num.containsKey(ch)) {
                    num.put(ch, 1);
                    first_point.put(ch, i);
                } else if (num.get(ch) == K) {
                    int idx = first_point.get(ch) + 1;
                    for (; idx <= i; idx++) {
                        if (str.charAt(idx) == ch) {
                            first_point.put(ch, idx);
                            break;
                        }
                    }
                    int length = i - first_point.get(ch) + 1;
                    answer = Math.min(answer, length);
                    answer2 = Math.max(answer2, length);
                }else if (num.get(ch) == K - 1) {
                    check = true;
                    num.put(ch, K);
                    int length = i - first_point.get(ch) + 1;
                    answer = Math.min(answer, length);
                    answer2 = Math.max(answer2, length);
                }
                else{
                    num.put(ch, num.get(ch) + 1);
                }
            }
            if(check) sb.append(answer + " " + answer2+"\n");
            else sb.append(-1 + "\n");
        }
        System.out.print(sb);
    }
}