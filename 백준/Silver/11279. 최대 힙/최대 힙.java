import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer>pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                if(pQ.isEmpty()) System.out.println(0);
                else System.out.println(pQ.poll());
            }else{
                pQ.offer(tmp);
            }
        }
    }
}