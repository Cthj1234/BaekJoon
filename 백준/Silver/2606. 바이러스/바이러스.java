import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main{
    static int N,M;
    static int answer = 0;
    static int[][] arr;
    static boolean[] check;

    public static void DFS(int L){
        check[L] = true;

        for(int i = 1; i <= N; i++){
            if(arr[L][i] == 1 && !check[i]){
                answer ++;
                DFS(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        check = new boolean[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        DFS(1);
        System.out.println(answer);
    }
}