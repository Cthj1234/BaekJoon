import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution{

    public int solution(String[][] book_time) {
        int[][] timeList = new int[book_time.length][2];
        int idx = 0;

        for (String[] time : book_time) {
            int start = Integer.parseInt(time[0].replace(":", ""));
            int end = Integer.parseInt(time[1].replace(":", ""));
            int tmp = end % 100;
            if(tmp >= 50){
                end = end + 50;
            } else end = end + 10;

            timeList[idx][0] = start;
            timeList[idx++][1] = end;

        }
        Arrays.sort(timeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] x : timeList) {
            if(pq.isEmpty()){
                pq.add(x[1]);
                continue;
            }

            if (x[0] >= pq.peek()) {
                pq.poll();
                pq.add(x[1]);
            }else{
                pq.add(x[1]);
            }


        }
        return pq.size();
    }
}