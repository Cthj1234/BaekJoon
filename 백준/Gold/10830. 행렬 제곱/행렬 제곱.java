import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] answer;

    public static int[][] multiply(int[][] o1, int[][] o2) {
        int N = o1.length;
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= 1000; // MOD 처리
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] arr = new int[N][N];
        answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                answer[i][j] = (i == j) ? 1 : 0;
            }
        }

        while (B > 0) {
            if (B % 2 == 1) {
                // 중간 결과를 직접 answer 배열에 저장
                answer = multiply(answer, arr);
            }
            // answer 배열을 계산 중간에 직접 갱신
            arr = multiply(arr, arr);
            B /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}