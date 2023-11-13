import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!pQ.isEmpty()){
                    sb.append(pQ.poll()).append("\n");
                }else{
                    sb.append("0\n");
                }
            }else{
                pQ.offer(x);
            }
        }
        System.out.println(sb);
    }
}