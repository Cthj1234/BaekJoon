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

        Set<String> list = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            if(list.contains(tmp)){
                answer.add(tmp);
                count ++;
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(count + "\n");
        for(String x : answer){
            sb.append(x + "\n");
        }
        System.out.print(sb);
    }
}