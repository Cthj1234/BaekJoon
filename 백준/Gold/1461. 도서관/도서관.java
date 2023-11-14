import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // 절댓값 기준 가장 큰 숫자는 1번만 가면 된다.
        int Max = Integer.MIN_VALUE;
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 절댓값 기준 큰 숫자들이 우선순위
        PriorityQueue<Integer> Negative_pQ = new PriorityQueue<>();
        PriorityQueue<Integer> Positive_pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : arr){
            if(x > 0) Positive_pQ.add(x);
            else Negative_pQ.add(x);
            Max = Math.max(Max, Math.abs(x));
        }

        int tmp = 0;

        while(!Negative_pQ.isEmpty()){
            tmp = Negative_pQ.peek();

            for(int i = 0; i < M; i++){
                Negative_pQ.poll();
                if(Negative_pQ.isEmpty()) break;
            }

            answer += 2 * Math.abs(tmp);
        }

        while(!Positive_pQ.isEmpty()){
            tmp = Positive_pQ.peek();

            for(int i = 0; i < M; i++){
                Positive_pQ.poll();
                if(Positive_pQ.isEmpty()) break;
            }

            answer += 2 * tmp;
        }
        answer -= Max;
        System.out.println(answer);
    }
}