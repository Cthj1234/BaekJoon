import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N = 0, M = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dice = new int[6];
        int x = 0, y = 0, K = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            // 동 서 북 남
            if (dir == 1) {
                if (y == M - 1) {
                    continue;
                }
                y += 1;
            } else if (dir == 2) {
                if (y == 0) {
                    continue;
                }
                y -= 1;
            } else if (dir == 3) {
                if (x == 0) {
                    continue;
                }
                x -= 1;
            } else {
                if (x == N - 1) {
                    continue;
                }
                x += 1;
            }

            moveDice(dir, map[x][y], dice, x, y);
        }


    }

    public static void moveDice(int dir, int cur, int[] dice,int x , int y) {
        int tmp = 0;

        // 천장 = dice[1] , 바닥 = dice[3]
        if (dir == 1) {
            tmp = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = tmp;
            if (cur == 0) {
                map[x][y] = dice[3];
            } else {
                dice[3] = cur;
                map[x][y] = 0;
            }
        } else if (dir == 2) {
            tmp = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = tmp;
            if (cur == 0) {
                map[x][y] = dice[3];
            } else {
                dice[3] = cur;
                map[x][y] = 0;
            }
        } else if (dir == 3) {
            tmp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = tmp;
            if (cur == 0) {
                map[x][y] = dice[3];
            } else {
                dice[3] = cur;
                map[x][y] = 0;
            }
        } else {
            tmp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = tmp;
            if (cur == 0) {
                map[x][y] = dice[3];
            } else {
                dice[3] = cur;
                map[x][y] = 0;
            }
        }
        System.out.println(dice[1]);
    }
}