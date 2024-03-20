import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {

    int d;
    int cost;

    public Point(int d, int cost) {
        this.d = d;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point o) {
        return this.cost - o.cost;
    }
}


class Main{
    static int N, M;
    static ArrayList<Point>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void dijkstra() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        dist[1] = 0;
        queue.offer(new Point(1, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if(!visited[current.d]) visited[current.d] = true;
            else continue;

            for (int i = 0; i < list[current.d].size(); i++) {
                Point next = list[current.d].get(i);
                if (dist[next.d] > dist[current.d] + next.cost) {
                    dist[next.d] = dist[current.d] + next.cost;
                    queue.offer(new Point(next.d, dist[next.d]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, cost));
            list[end].add(new Point(start, cost));
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra();
        System.out.print(dist[N]);
    }

}