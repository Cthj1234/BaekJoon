import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main{
    static int N, M;
    static int[][] arr;
    static int[] dx = {0,1,0,-1} , dy = {1, 0, -1, 0};
    static int answer = 1;

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx == N && ny == M){
                    answer = arr[tmp.x][tmp.y] + 1;
                    return;
                }
                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[nx][ny] == 1){
                    arr[nx][ny] = arr[tmp.x][tmp.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
            answer++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            String tmp = br.readLine();
            for(int j = 1; j <= M; j++){
                arr[i][j] = tmp.charAt(j - 1) - '0';
            }
        }

        BFS(1, 1);
        System.out.println(answer);
    }
}