import java.util.ArrayList;
import java.util.Collections;

class Hotel implements Comparable<Hotel>{

    public int start, end;

    public Hotel(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Hotel o) {
        if(this.end == o. end) return this.start - o.start;
        return this.end - o.end;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<Hotel> list = new ArrayList<>();
        for (String[] time : book_time) {
            int start = Integer.parseInt(time[0].replace(":", ""));
            int end = Integer.parseInt(time[1].replace(":", ""));
            int tmp = end % 100;
            if(tmp >= 50){
                end = end + 50;
            } else end = end + 10;

            list.add(new Hotel(start, end));
        }
        Collections.sort(list);

        int size = list.size();
        for (int i = 0; i < size; i++) {
            int count = 1;
            int end = list.get(i).end;
            for (int j = i + 1; j < size; j++) {
                int start = list.get(j).start;
                if(start < end) count++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}