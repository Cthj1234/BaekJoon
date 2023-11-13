import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = K;
        int count = 0;
        int tmp = Integer.MIN_VALUE;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > K) {
                tmp = i-1;
                break;
            }
            if(tmp == Integer.MIN_VALUE) tmp = N-1;
        }

        while(true){
            if(sum == 0) break;
            if(arr[tmp] > sum) tmp--;
            else{
                sum -= arr[tmp];
                count++;
            }
        }
        System.out.println(count);
    }
}