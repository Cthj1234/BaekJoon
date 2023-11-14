import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K+1];
        boolean[] check = new boolean[101];
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 0;
        int count = 0;

        while(true){
            if(count == N) break;
            if (!check[arr[tmp]]) {
                check[arr[tmp]] = true;
                count++;
            }
            tmp++;
        }

        // 모든 멀티텝에 콘센트가 꽂혀있는 상태
        while(tmp < K){

            // 사용하려는 플래그가 꽂혀 있지 않은 경우 새로운 list에 현재 꽂혀져있는 플래그들 저장.
            // (나중에 사용 될 순서대로 저장된다)
            if(!check[arr[tmp]]){
                List<Integer> list = new ArrayList<>();
                for(int i = tmp; i < K; i++){
                    if (check[arr[i]] && !list.contains(arr[i])) {
                        list.add(arr[i]);
                    }
                }

                // 모두 꽂혀져있는 경우 가장 마지막에 사용 될 코드를 뽑음.
                if(list.size() == N){
                    check[list.get(list.size()-1)] = false;
                }else{
                    for(int i = 1; i <= K; i++){
                        if(check[i] && !list.contains(i)){
                            check[i] = false;
                            break;
                        }
                    }
                }
                answer++;
                check[arr[tmp]] = true;
            }
            tmp ++;
        }

        System.out.println(answer);
    }
}