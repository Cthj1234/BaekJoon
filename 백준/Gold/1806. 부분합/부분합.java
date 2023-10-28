import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int find_num = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0,rt = 0, lt = 0;

        int tmp = Integer.MAX_VALUE;
        while(lt <= rt && rt <= N){
            if(sum < find_num) sum += arr[rt++];
            else if(sum >= find_num){
                tmp = Math.min(tmp, rt - lt);
                sum -= arr[lt++];
            }
        }
        System.out.println(tmp == Integer.MAX_VALUE ? 0 : tmp);
    }
}