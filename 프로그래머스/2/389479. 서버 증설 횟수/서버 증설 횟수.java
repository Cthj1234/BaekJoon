import java.util.LinkedList;
import java.util.Queue;

class Server {
    int lastTime;
    int serverTotal;

    public Server(int lastTime, int serverTotal) {
        this.lastTime = lastTime;
        this.serverTotal = serverTotal;
    }
}

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int total = 0;
        Queue<Server> serverQueue = new LinkedList<>();
        for (int i = 0; i < 24; i++) {
            // 서버 증설시간 만료
            if (!serverQueue.isEmpty() && serverQueue.peek().lastTime == i) {
                total -= serverQueue.peek().serverTotal;
                serverQueue.poll();
            }
            int people = players[i];

            if ((people / m) > total) {
                int addServer = (people / m) - total;
                serverQueue.add(new Server(i + k, addServer));
                answer += addServer;
                total += addServer;
            }
        }
        return answer;
    }
}
/*
class Main{
    public static void main(String[] args) {
        int[] players = {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
        Solution solution = new Solution();
        int a = solution.solution(players, 5, 1);
        System.out.println(a);
    }
}*/
