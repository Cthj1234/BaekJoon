import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class problem implements Comparable<problem>{
    public int dead_line, get_cup;

    public problem(int dead_line, int get_cup) {
        this.dead_line = dead_line;
        this.get_cup = get_cup;
    }

    @Override
    public int compareTo(problem o) {
        if(this.dead_line == o.dead_line) return o.get_cup - this.get_cup;
        else return this.dead_line - o.dead_line;
    }
}
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<problem> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;


        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dead_line = Integer.parseInt(st.nextToken());
            int get_cup = Integer.parseInt(st.nextToken());
            list.add(new problem(dead_line, get_cup));
        }

        Collections.sort(list);

        for (problem current : list) {
            queue.add(current.get_cup);
            if (queue.size() > current.dead_line) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            answer += queue.poll();
        }
        
        System.out.print(answer);

    }
}