import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class Main{
    static int[] dx = {0,1,0,-1}, dy = {1, 0, -1, 0};
    static char[][] board;
    static int answer;
    static boolean[][] visited;
    static ArrayList<Point> list;

    public static void ChangePosition(){
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        list.add(queue.peek());
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (board[point.x][point.y] == board[nx][ny] && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        list.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[12][6];
        answer = 0;
        visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        int count = 0;

        while (true) {
            boolean check = true;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.') {
                        list = new ArrayList<>();
                        BFS(i, j);

                        if (list.size() >= 4) {
                            check = false;
                            for (int k = 0; k < list.size(); k++) {
                                board[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if(check) break;
            ChangePosition();
            count++;
        }
        System.out.println(count);
    }
}