import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int M;
    static int arr[];
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L, int num){
        int count = 1;

        if(num > N) return;

        if(L == M){

            for(int i = 1; i < arr.length; i++){
                sb.append(arr[i] + " ");
            }

            System.out.println(sb);
            sb.setLength(0);
            return;
        }


        for(int i = 0; i < N; i++){
            if(!check[i+1]){
                check[i+1] = true;
                arr[L + 1] = i + 1;
                DFS(L + 1, num + 1);
                check[i+1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        arr = new int[M + 1];
        DFS(0, 0);

    }
}