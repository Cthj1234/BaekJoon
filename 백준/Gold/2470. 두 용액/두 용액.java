import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int lt = 0;
        int rt = N - 1;
        int tmp = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            int abs = Math.abs(sum);

            if (abs < tmp) {
                tmp = abs;
                num1 = arr[lt];
                num2 = arr[rt];
            }

            if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(num1 + " " + num2);
    }
}