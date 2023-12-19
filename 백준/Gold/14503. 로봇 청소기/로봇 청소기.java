import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, answer = 0;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, int d, int sum) {
        if (room[x][y] == 0) {
            sum++;
            room[x][y] = 2; // 청소한 영역을 2로 표시
        }

        boolean check = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (room[nx][ny] == 0) {
                    check = true;
                }
            }
        }

        // 빈칸이 있는 경우
        if (check) {
            boolean cleaned = false; 
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
                    DFS(nx, ny, d, sum);
                    cleaned = true; 
                    break; 
                }
            }

            if (!cleaned) { 
                int nx = x + dx[(d + 2) % 4];
                int ny = y + dy[(d + 2) % 4];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] != 1) {
                    DFS(nx, ny, d, sum);
                } else {
                    answer = Math.max(answer, sum);
                }
            }
        } else {
            int nx = x + dx[(d + 2) % 4];
            int ny = y + dy[(d + 2) % 4];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] != 1) {
                DFS(nx, ny, d, sum);
            } else {
                answer = Math.max(answer, sum);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(x, y, d, 0);
        System.out.println(answer);
    }
}