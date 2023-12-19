import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Main{
    static int N, K;
    static int[][] board;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visited = new boolean[N];
        boolean[] check = new boolean[N];
        check[K] = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 플로이드 - 워셜 알고리즘 - 모든 최단 경로를 구하는 알고리즘
         * 시간복잡도가 O(n^3)인 알고리즘이므로 신중하게 사용할것
         *
         */
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (board[i][j] > board[i][k] + board[k][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }


        visited[K] = true;
        DFS(1, K, 0);
        System.out.println(answer);
    }

    static void DFS(int count, int prev, int sum) {
        if(count == N){
            answer = Math.min(answer, sum);
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            DFS(count + 1, i, sum + board[prev][i]);
            visited[i] = false;
        }
    }
}