import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int tmp : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(tmp);
                    sum += tmp;
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (sum + tmp > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(tmp);
                        sum += tmp;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}