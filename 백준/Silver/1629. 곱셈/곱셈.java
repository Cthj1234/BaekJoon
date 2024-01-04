import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = 1;

        while (B > 0) {
            if (B % 2 == 1) {
                answer = (answer * A) % C;
            }

            A = (int)((long)A * A % C);
            B /= 2;
        }
        System.out.println(answer % C);
    }
}