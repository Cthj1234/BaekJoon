import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    static int N,C, mid;

    public static void DFS(int L, int sum, ArrayList<Integer> weight, ArrayList<Integer> answer) {
        if(sum > C) return;
        if(L == weight.size()){
            answer.add(sum);
            return;
        }
        
        // 물건 넣는 경우
        DFS(L + 1, sum + weight.get(L), weight, answer);
        //물건 안넣는 경우
        DFS(L + 1, sum, weight, answer);
    }

    public static int BinarySearch(ArrayList<Integer> sum, int target) {
        int lt = 0, rt = sum.size()-1, mid, answer = -1;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if(sum.get(mid) <= target){
                answer = mid;
                lt = mid + 1;
            }else rt = mid -1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mid = N / 2;

        ArrayList<Integer> weight1 = new ArrayList<>();
        ArrayList<Integer> weight2 = new ArrayList<>();
        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if(i < mid) weight1.add(Integer.parseInt(st.nextToken()));
            else weight2.add(Integer.parseInt(st.nextToken()));
        }

        DFS(0, 0, weight1, sum1);
        DFS(0, 0, weight2, sum2);

        Collections.sort(sum2);
        long answer = 0;

        for (int i = 0; i < sum1.size(); i++) {
            int Search_value = C - sum1.get(i);
            answer += BinarySearch(sum2, Search_value) + 1;
        }

        System.out.print(answer);
    }
}