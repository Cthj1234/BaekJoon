import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int[][] board;
    static List<int[]> snake;
    static int N, K, L;
    static HashMap<Integer, String> hashMap;

    // 동,남,서,북
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        snake = new ArrayList<>();
        hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            hashMap.put(tmp, st.nextToken());
        }

        // 첫 좌표 저장
        snake.add(new int[]{0, 0});

        Execute();
    }

    public static void Execute() {
        int time = 1;
        int currentX = 0;
        int currentY = 0;
        int direction = 0;

        while (true) {
            int nx = currentX + dx[direction];
            int ny = currentY + dy[direction];

            if (isFinished(nx, ny)) {
                break;
            }

            // 사과 먹는 경우에는 길이가 늘어나기만함
            if(board[nx][ny] == 1){
                snake.add(new int[]{nx, ny});
                board[nx][ny] = 0;
            }else{
                snake.remove(0);
                snake.add(new int[]{nx, ny});
            }

            if(hashMap.containsKey(time)){
                String str = hashMap.get(time);
                if (str.equals("L")) {
                    direction--;
                    if (direction == -1) {
                        direction = 3;
                    }
                }else{
                    direction++;
                    if(direction == 4){
                        direction = 0;
                    }
                }
            }
            currentX = nx;
            currentY = ny;
            time++;
        }
        System.out.println(time);
    }

    public static boolean isFinished(int nx, int ny) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            // 벽에 부딪치는 경우 => 게임 끝
            return true;
        } else {
            for (int[] arr : snake) {
                // 몸에 부딪치면 끝
                if (arr[0] == nx && arr[1] == ny) {
                    return true;
                }
            }
        }
        return false;
    }
}