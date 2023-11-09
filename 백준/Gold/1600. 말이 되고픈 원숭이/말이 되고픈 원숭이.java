import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x, y, count, answer;
    public Point(int x, int y, int count, int answer){
        this.x = x;
        this. y = y;
        this.count = count;
        this.answer = answer;
    }
}

class Main{
    static int K,N,M;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] horse_dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] horse_dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static int BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0,0));
        boolean[][][] check = new boolean[M + 1][N + 1][K + 1];
        check[x][y][0] = true;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            int count = tmp.count;
            int answer = tmp.answer;
            if(tmp.x == N && tmp.y == M){
                return tmp.answer;
            }
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[ny][nx] == 0){
                    if(check[ny][nx][count]) continue;
                    check[ny][nx][count] = true;
                    queue.add(new Point(nx, ny, count,answer+1));
                }
            }

            if(tmp.count < K){
                for(int i = 0; i < 8; i++){
                    int nx = tmp.x + horse_dx[i];
                    int ny = tmp.y + horse_dy[i];

                    if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[ny][nx] == 0){
                        if(check[ny][nx][count+1])continue;
                        check[ny][nx][count+1] = true;
                        queue.add(new Point(nx, ny, count + 1, answer + 1));
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1][N + 1];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(BFS(1,1));
    }
}