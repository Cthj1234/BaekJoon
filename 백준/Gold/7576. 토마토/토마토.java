import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main{
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int M, N, count = 0, answer = 0;
    static int[][] arr;
    static Queue<Point>queue;
    static boolean check = true;

    public static void BFS(int x, int y){
        while(!queue.isEmpty()){
            int num = queue.size();
            boolean check = false;
            for(int i = 0; i < num; i++){
                Point tmp = queue.poll();
                for(int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[nx][ny] == 0){
                        arr[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                        check = true;
                        count --;
                    }
                }
            }
            if(!check) break;
            answer ++;
        }
        if(count != 0) answer = -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N+1][M+1];
        queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) count++;
                else if(arr[i][j] == 1) queue.offer(new Point(i, j));
            }
        }
        BFS(1,1);
        System.out.println(answer);
    }
}