import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dis = new int[N - 1];
        int[] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) dis[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) price[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int min_price = price[0];
        for(int i = 0; i< dis.length; i++){
            answer += (min_price * dis[i]);
            if(price[i+1] < min_price) min_price = price[i + 1];
        }
        System.out.println(answer);
    }
}