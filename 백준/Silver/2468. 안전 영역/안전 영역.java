import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class Main{
    static int N, max_height = 0, min_height = Integer.MAX_VALUE, answer;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] visited;

    public static void Change_board(int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] <= num) board[i][j] = 0;
            }
        }
    }

    public static void BFS(int num){
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > num && !visited[i][j]) {
                    queue.add(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = point.x + dx[k];
                            int ny = point.y + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] > num) {
                                queue.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    count ++;
                }
            }
        }
        visited = new boolean[N][N];
        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, board[i][j]);
                min_height = Math.min(min_height, board[i][j]);
            }
        }

        answer = 1;

        for (int i = min_height; i <= max_height; i++) {
            Change_board(i);
            BFS(i);
        }

        System.out.print(answer);
    }
}