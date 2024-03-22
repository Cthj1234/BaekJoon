import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int R, C, answer;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1};
    static boolean check;

    public static void DFS(int r, int c) {
        if (c == C - 1) {
            answer++;
            check = true;
            visited[r][c] = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = r + dx[i];
            int ny = c + 1;

            if(!(nx >= 0 && nx < R && ny >= 0 && ny < C)) continue;
            if (board[nx][ny] == '.' && !visited[nx][ny]) {
                DFS(nx, ny);
                if (check) {
                    visited[r][c] = true;
                    return;
                }else visited[r][c] = true;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            check = false;
            DFS(i, 0);
        }

        System.out.print(answer);



    }
}