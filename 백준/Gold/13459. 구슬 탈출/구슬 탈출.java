import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Turn{
    public int red_x,red_y,blue_x,blue_y;

    public Turn(int red_x, int red_y, int blue_x, int blue_y) {
        this.red_x = red_x;
        this.red_y = red_y;
        this.blue_x = blue_x;
        this.blue_y = blue_y;
    }
}

class Marble{
    public int x, y, dist;

    public Marble(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Main{
    static int N, M;
    static char[][] board;
    static int[] dx = {0,1,0,-1}, dy = {1, 0, -1, 0};
    static boolean[][][][] visited;

    public static int BFS(int red_x, int red_y, int blue_x, int blue_y){
        Queue<Turn> queue = new LinkedList<>();
        queue.add(new Turn(red_x, red_y, blue_x, blue_y));
        int time = 1;
        visited[red_x][red_y][blue_x][blue_y] = true;

        Marble red = null, blue = null;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while(size-- > 0){
                Turn now = queue.poll();
                for (int i = 0; i < 4; i++) {
                     red = move(now.red_x, now.red_y, 0, i);
                     blue = move(now.blue_x, now.blue_y, 0, i);

                    if(board[blue.x][blue.y] == 'O') continue;

                    if(board[red.x][red.y] == 'O') return 1;

                    if (red.x == blue.x && red.y == blue.y) {
                        if (red.dist > blue.dist) {
                            red.x -= dx[i];
                            red.y -= dy[i];
                        }else{
                            blue.x -= dx[i];
                            blue.y -= dy[i];
                        }
                    }

                    if(visited[red.x][red.y][blue.x][blue.y])continue;

                    visited[red.x][red.y][blue.x][blue.y] = true;

                    queue.add(new Turn(red.x, red.y, blue.x, blue.y));
                }
            }

            if(++time > 10)return 0;
        }
        return 0;
    }

    public static Marble move(int x, int y, int dist, int d) {
        int after_x = x, after_y = y;

        while (board[after_x + dx[d]][after_y + dy[d]] != '#' && board[after_x][after_y] != 'O') {
            after_x += dx[d];
            after_y += dy[d];
            dist++;
        }

        return new Marble(after_x, after_y, dist);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        int red_x = 0, red_y = 0, blue_x = 0, blue_y = 0;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
                if(board[i][j] == 'R'){
                    red_x = i;
                    red_y = j;
                }
                else if(board[i][j] == 'B') {
                    blue_x = i;
                    blue_y = j;
                }
            }
        }
        System.out.println(BFS(red_x, red_y, blue_x, blue_y));
    }
}