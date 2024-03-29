import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(arr[0]);
            return;
        }

        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        int lt = 0, rt = 0;

        while (rt < N) {
            int tmp = arr[rt] - arr[lt];

            if(tmp == M){
                System.out.print(M);
                return;
            } else if (tmp < M) {
                rt++;
                continue;
            }

            answer = Math.min(answer, tmp);
            lt++;
        }

        System.out.print(answer);

    }
}