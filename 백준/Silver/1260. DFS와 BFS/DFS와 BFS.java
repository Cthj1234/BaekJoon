import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int node, edge, start;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void DFS(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= node; i++) { // 변경된 루프 조건
            if (arr[start][i] == 1 && !check[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        DFS(start);
        sb.append("\n");
        check = new boolean[node + 1];

        BFS(start);

        System.out.println(sb);
    }
}