import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  // 테스트 케이스 수를 읽음
        StringTokenizer st;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());  // 편의점 수를 읽음
            int[][] locations = new int[n + 2][2];  // 상근이네 집, 편의점들, 페스티벌 장소 좌표 저장

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                locations[i][0] = Integer.parseInt(st.nextToken());
                locations[i][1] = Integer.parseInt(st.nextToken());
            }

            System.out.println(canReachFestival(locations, n) ? "happy" : "sad");
        }
    }

    public static boolean canReachFestival(int[][] locations, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];

        queue.add(locations[0]);  // 상근이네 집을 시작점으로 큐에 추가
        visited[0] = true;  // 상근이네 집 방문 표시

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 페스티벌 장소에 도달할 수 있는지 확인
            if (distance(current, locations[n + 1]) <= 1000) {
                return true;
            }

            // 방문하지 않은 각 지점을 확인하여 거리가 1000미터 이하인 경우 큐에 추가
            for (int i = 1; i < n + 2; i++) {
                if (!visited[i] && distance(current, locations[i]) <= 1000) {
                    queue.add(locations[i]);
                    visited[i] = true;
                }
            }
        }

        return false;  // 모든 경로를 탐색한 후에도 페스티벌 장소에 도달하지 못하면 "sad"
    }

    // 두 지점 사이의 맨해튼 거리를 계산하는 함수
    public static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
