import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            return;
        }
        
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int k  = Integer.parseInt(st.nextToken());
            dp[k] = dp[k - 1] + 1;
        }

        Arrays.sort(dp);
        System.out.println(N - dp[N]);

    }
}