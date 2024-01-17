import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static int N ,L, R;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0} , dy = {0, 1, 0, -1};
    static ArrayList<Point> list;

    // 연합의 총 합 구함
    public static int BFS(int x, int y){
        list = new ArrayList<>();
        visited[x][y] = true;

        int sum = board[x][y];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        list.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(board[point.x][point.y] - board[nx][ny]);
                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        sum += board[nx][ny];
                        queue.add(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                    }
                }
            }
        }
        return sum;
    }

    public static void ChangePopulation(int sum) {
        int avg = sum / list.size();
        for (Point p : list) {
            board[p.x][p.y] = avg;
        }
    }

    public static int Execute(){
        int result = 0;
        while (true) {
            boolean check = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        int sum = BFS(i, j);
                        if (list.size() > 1) {
                            ChangePopulation(sum);
                            check = true;
                        }
                    }
                }
            }
            if(!check) return result;
            result++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(Execute());
    }
}