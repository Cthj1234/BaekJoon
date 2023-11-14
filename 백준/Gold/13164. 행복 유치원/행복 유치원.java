import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] tmp = new Integer[N - 1];
        int answer = 0;

        for(int i = 0; i < N-1; i++){
            tmp[i] = arr[i + 1] - arr[i];
            answer += tmp[i];
        }

        Arrays.sort(tmp, Collections.reverseOrder());

        for(int i = 0; i < K-1; i++){
            answer -= tmp[i];
        }

        System.out.println(answer);
    }
}