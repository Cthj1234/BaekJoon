import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    static int N, M, K, start_x, start_y, end_x, end_y;
    static int[][] board;
    static LinkedList<Integer> list;

    // 사각형 채움
    public static void Execute_full() {
        for (int i = start_x; i < end_x; i++) {
            for (int j = start_y; j < end_y; j++) {
                if (board[i][j] == 0) board[i][j] = 1;
            }
        }
    }

    public static void DFS() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) list.add(BFS(i, j));
            }
        }
    }

    public static int BFS(int x, int y){
        int count = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    count++;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return count != 0 ? count : 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new LinkedList<>();

        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            Execute_full();
        }
        DFS();
        Collections.sort(list);
        System.out.println(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.printf(list.poll() + " ");
        }
    }
}