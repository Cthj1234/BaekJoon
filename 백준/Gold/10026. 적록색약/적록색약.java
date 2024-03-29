import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point implements Comparable<Point> {

    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return 0;
    }
}

class Main{
    static int N, answer = 0;
    static char[][] board;
    static int[] dx = {0,1,0,-1}, dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        char tmp = board[x][y];
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == tmp && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        answer++;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j);
                }
            }
        }

        System.out.print(answer + " ");
        answer = 0;

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 'G') board[i][j] = 'R';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) BFS(i, j);
            }
        }
        System.out.print(answer);

    }
}
