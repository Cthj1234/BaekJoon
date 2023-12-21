import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class box implements Comparable<box> {
    public int from, to, box_num;

    public box(int from, int to, int box_num) {
        this.from = from;
        this.to = to;
        this.box_num = box_num;
    }

    @Override
    public int compareTo(box o) {
        if(this.to == o. to) return this.from - o.from;
        return this.to - o.to;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<box> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int from,to,box_num;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            box_num = Integer.parseInt(st.nextToken());
            list.add(new box(from, to, box_num));

        }
        Collections.sort(list);
        int[] box = new int[N + 1];
        Arrays.fill(box, C);

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            from = list.get(i).from;
            to = list.get(i).to;
            box_num = list.get(i).box_num;
            int Min = Integer.MAX_VALUE;

            for (int j = from; j < to; j++) {
                Min = Math.min(Min, box[j]);
            }
            Min = Math.min(Min, box_num);
            answer += Min;
            for (int j = from; j < to; j++) {
                box[j] -= Min;
            }
        }

        System.out.println(answer);


    }
}
