import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Class implements Comparable<Class> {
    public int start, end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class o) {
        if(this.start == o.start) return this.end - o.end;
        return this.start - o.start;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Class> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Class(start, end));
        }
        Collections.sort(list);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);

        list.remove(list.get(0));

        for (Class current : list) {
            if (current.start >= pq.peek()) {
                pq.poll();
            }
            pq.add(current.end);
        }
        System.out.println(pq.size());
    }
}