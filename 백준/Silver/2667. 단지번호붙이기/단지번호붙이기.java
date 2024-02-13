import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main{

    public static void BFS(int N,int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        LinkedList<Integer> answer = new LinkedList<>();
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    queue.add(new Point(i, j));
                    board[i][j] = 0;
                    int count = 0;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;
                        count++;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                                if(board[nx][ny] == 1){
                                    queue.add(new Point(nx, ny));
                                    board[nx][ny] = 0;
                                }
                            }
                        }
                    }
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int x : answer){
            System.out.println(x);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        BFS(N, board);

    }

}