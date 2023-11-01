import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static StringBuilder sb = new StringBuilder();

    public static void Hanoi(int N, int start, int mid, int end){
        if(N == 1){
            sb.append(start + " " + end + "\n");
            return;
        }

        Hanoi(N - 1, start, end, mid);
        sb.append(start + " " + end + "\n");
        Hanoi(N-1, mid, start, end);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = (int)(Math.pow(2, N) - 1);
        sb.append(count + "\n");
        Hanoi(N, 1, 2, 3);
        System.out.print(sb);
    }
}