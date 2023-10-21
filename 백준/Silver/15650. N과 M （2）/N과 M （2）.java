import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N,M;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L, int num){
        if(L == M){
            for(int i = 1; i < ch.length;i ++){
                if(ch[i] == 1) sb.append(i + " ");
            }
            if(sb.length() > 0) System.out.println(sb);
            sb.setLength(0);
        }else{
            if(num >= N) return;
            ch[num + 1] = 1;
            DFS(L + 1, num + 1);
            ch[num + 1] = 0;
            DFS(L, num + 1);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N+1];
        DFS(0, 0);
    }
}