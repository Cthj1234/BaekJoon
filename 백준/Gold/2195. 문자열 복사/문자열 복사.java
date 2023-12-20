import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String before = st.nextToken();
        String after = new StringTokenizer(br.readLine()).nextToken();
        String tmp = "";
        int answer = 0;
        int index = 0;

        for (int i = 0; i < after.length(); i++) {
            tmp += after.charAt(i);
            if (i < after.length() - 1 && before.contains(tmp + after.charAt(i + 1))) continue;
            tmp = "";
            answer++;
        }
        System.out.println(answer);
    }
}