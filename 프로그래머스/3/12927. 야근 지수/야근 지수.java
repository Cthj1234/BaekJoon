import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        long total = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
            total += works[i];
        }

        if (total < n) {
            return 0;
        }

        while(n -- > 0){
            int num = pq.poll();
            pq.add(--num);
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += Math.pow(num, 2);
        }

        return answer;
    }
}