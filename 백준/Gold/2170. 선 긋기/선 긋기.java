import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Line implements Comparable<Line>{

    public int start,end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line o) {
        if(this.start == o.start) return o.end - this.end;
        return this.start - o.start;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Line(start, end));
        }

        Collections.sort(list);

        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE, answer = 0;

        for (Line current : list) {
            if(current.end < end) continue;
            start = Math.max(current.start, end);
            end = current.end;
            answer += (end - start);
        }

        System.out.println(answer);
    }
}