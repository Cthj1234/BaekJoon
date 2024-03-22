import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{

    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main{
    static int N, M;
    static int[][] board;
    static int answer = 0;
    static int total = 0;

    public static void BFS(int x, int y){
        boolean check;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            check = false;

            for (int i = current.y + 1; i < M; i++) {
                if(board[current.x][i] == 1){
                    check = true;
                    board[current.x][i] = 0;
                    total--;
                    queue.add(new Point(current.x,i));
                    break;
                }
            }

            if (!check && current.x < N - 1) {
                queue.add(new Point(current.x + 1, current.y));
                if (board[current.x + 1][current.y] == 1) {
                    total--;
                    board[current.x + 1][current.y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) total++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 0;
                    total--;
                    BFS(i,j);
                    answer++;
                }
                if(total == 0) {
                    System.out.print(answer);
                    return;
                }
            }
        }
    }

}