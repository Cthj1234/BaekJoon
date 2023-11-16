import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        // 공기청정기는 1열에 위치하므로 행 위치만 저장하면 됨.
        // 공기청정기 좌표 중 아래 위치를 저장함.
        int air_clean = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) air_clean = i;
            }
        }

        while (T != 0) {
            int[][] tmp = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int num = board[i][j];
                    int spread_air = num / 5;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            // 공기청정기가 없는 경우에만 확산한다.
                            if (board[nx][ny] != -1) {
                                tmp[nx][ny] += spread_air;
                                tmp[i][j] -= spread_air;
                            }
                        }
                    }
                }
            }

            // 최종적으로 1초동안 확산 된 공기상태를 board로 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    board[i][j] += tmp[i][j];
                }
            }


            // 위쪽, 반시계 탐방과정
            int x = air_clean - 1;
            int y = 1;
            int after, temp;
            temp = board[x][y];
            board[x][y] = 0;

            for (; y < M - 1; y++) {
                after = board[x][y + 1];
                board[x][y + 1] = temp;
                temp = after;
            }

            for (; x > 0; x--) {
                after = board[x - 1][y];
                board[x - 1][y] = temp;
                temp = after;
            }

            for (; y > 0; y--) {
                after = board[x][y - 1];
                board[x][y - 1] = temp;
                temp = after;
            }

            for (; x < air_clean - 1; x++) {
                after = board[x + 1][y];
                board[x + 1][y] = temp;
                temp = after;
            }


            // 시계방향 탐색 , air_clean 좌표
            x = air_clean;
            y = 1;
            temp = board[x][y];
            board[x][y] = 0;

            for (; y < M-1; y++) {
                after = board[x][y + 1];
                board[x][y + 1] = temp;
                temp = after;
            }

            for (; x < N - 1; x++) {
                after = board[x + 1][y];
                board[x + 1][y] = temp;
                temp = after;
            }

            for (; y > 0; y--) {
                after = board[x][y - 1];
                board[x][y - 1] = temp;
                temp = after;
            }

            for (; x > air_clean; x--) {
                after = board[x - 1][y];
                board[x - 1][y] = temp;
                temp = after;
            }

            // 공기청정기로 공기 날려버리는 과정.
            board[air_clean-1][0] = board[air_clean][0] = -1;

            --T;
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                answer += board[i][j];
            }
        }

        // -1 2개가 빠졌으므로 2를 더해준다.
        System.out.println(answer + 2);
    }
}