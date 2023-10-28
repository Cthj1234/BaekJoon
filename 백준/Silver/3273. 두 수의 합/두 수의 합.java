import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        int find_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            if(set.contains(find_num - arr[i])){
                answer++;
            }
        }
        
        // 예를들어 find_num = 4이고 1,3이 있을때 1과 3에서 answer++ 되기 때문에
        // 2를 나눠준다
        System.out.println(answer/2);
    }
}