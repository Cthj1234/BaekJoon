import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int M;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L, int num){
        if(num > N) return;

        if(L == M){

            for(int i = 1; i < arr.length; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }


        for(int i = 0; i < N; i++){
            arr[L + 1] = i + 1;
            DFS(L + 1, num + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
        DFS(0, 0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
