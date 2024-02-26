import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

class Main{
    static int[] dx = {0,1,0,-1}, dy = {1, 0, -1, 0};
    static char[][] board;
    static boolean[][] visited_water, visited_s;
    static boolean check;
    static int R,C,answer;
    static Queue<Point> water_queue, S_queue;

    // 물 좌표 구하는 메소드
    public static void BFS_Water(){
        int num = water_queue.size();
        while (num != 0 && !water_queue.isEmpty()) {
            Point point = water_queue.poll();
            visited_water[point.x][point.y] = true;
            for (int i = 0; i < 4; i++) {
                 int nx = point.x + dx[i];
                 int ny = point.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited_water[nx][ny]) {
                    if (board[nx][ny] == '.' || board[nx][ny] == 'S') {
                        board[nx][ny] = '*';
                        water_queue.add(new Point(nx, ny));
                    }
                }
            }
            num--;
        }
    }

    // 고슴도치 좌표 구하는 메소드
    public static boolean BFS_S() {
        int num = S_queue.size();
        while (num != 0 && !S_queue.isEmpty()) {
            Point point = S_queue.poll();
            visited_s[point.x][point.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited_s[nx][ny]) {
                    if(board[nx][ny] == 'D') return true;
                    else if (board[nx][ny] == '.') {
                        board[nx][ny] = 'S';
                        S_queue.add(new Point(nx, ny));
                    }
                }
            }
            num --;
            if(S_queue.isEmpty()) check = false;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        check = true;
        board = new char[R][C];
        visited_s = new boolean[R][C];
        visited_water = new boolean[R][C];
        answer = Integer.MAX_VALUE;

        water_queue = new LinkedList<>();
        S_queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = tmp.charAt(j);
                if (board[i][j] == '*') {
                    water_queue.add(new Point(i, j));
                } else if (board[i][j] == 'S') {
                    S_queue.add(new Point(i, j));
                }
            }
        }

        int count = 0;

        while (true) {
            count++;
            BFS_Water();
            boolean answer_check = BFS_S();
            if(answer_check || !check) break;
        }
        System.out.print(check ? count : "KAKTUS");
    }
}