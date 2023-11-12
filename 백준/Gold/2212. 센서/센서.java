import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        int sum = 0;
        Integer[] diff = new Integer[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        sum = arr[N - 1] - arr[0];

        for(int i = 1; i < N; i++){
            diff[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(diff,Collections.reverseOrder());

        for(int i = 0; i < Math.min(K-1, N-1); i++){
            sum -= diff[i];
        }
        
        System.out.println(sum);
    }
}