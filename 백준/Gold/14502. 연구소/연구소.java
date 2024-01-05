import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus{
    public int x, y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main{
    static int N, M;
    static int[][] board;
    static int[] dx = {-1,0,1,0} , dy = {0, 1, 0, -1};
    static int answer = Integer.MIN_VALUE;

    public static void DFS(int depth) {
        if(depth == 3){
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 0){
                    board[i][j] = 1;
                    DFS(depth + 1);
                    board[i][j] = 0;
                }
            }
        }

    }

    public static void BFS(){
        int[][] tmp_board = new int[N][M];
        Queue<Virus> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp_board[i][j] = board[i][j];
                if(tmp_board[i][j] == 2){
                    queue.add(new Virus(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int nx, ny;
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = virus.x + dx[i];
                ny = virus.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmp_board[nx][ny] == 0) {
                    tmp_board[nx][ny] = 2;
                    queue.add(new Virus(nx, ny));
                }
            }
        }

        Calculate_Result(tmp_board);

    }

    public static void Calculate_Result(int[][] tmp_board){
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tmp_board[i][j] == 0) count++;
            }
        }
        answer = Math.max(answer, count);
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
            }
        }
        DFS(0);
        System.out.println(answer);
    }
}