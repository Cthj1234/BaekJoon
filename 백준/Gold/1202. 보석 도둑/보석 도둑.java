import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel>{

    public int weight, cost;

    public Jewel(int weight, int cost){
        this.weight = weight;
        this.cost = cost;
    }
    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight;
    }
}


class Main{
    static int N,K;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList<Jewel> list = new ArrayList<>();
        int[] bag = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Jewel(weight, cost));
        }

        Collections.sort(list);

        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        // 가격을 내림차순
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int tmp = 0;
        for(int i = 0; i < K; i++){
            while(tmp < N && list.get(tmp).weight <= bag[i]){
                pQ.add(list.get(tmp++).cost);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }

        System.out.println(answer);

    }
}