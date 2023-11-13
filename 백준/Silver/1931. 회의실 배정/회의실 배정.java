import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    public int start, end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Meeting> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        Collections.sort(list);
        int tmp = -1;
        int answer = 0;

        for(Meeting o : list){
            if(o.start >= tmp) {
                answer ++;
                tmp = o.end;
            }
        }
        System.out.println(answer);
    }
}