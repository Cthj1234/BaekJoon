import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N;i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int answer = dp[c][d] - dp[a - 1][d] - dp[c][b - 1] + dp[a - 1][b - 1];
            sb.append(answer + "\n");
        }

        System.out.print(sb);

    }
}