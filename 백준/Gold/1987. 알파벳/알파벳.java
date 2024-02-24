import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main{
    static int R, C,answer;
    static char[][] board;
    static int[] dx = {0,1,0,-1}, dy = {1, 0, -1, 0};

    public static void DFS(int x, int y, int sum, ArrayList<Character> list) {
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!list.contains(board[nx][ny])) {
                    list.add(board[nx][ny]);
                    DFS(nx, ny, sum + 1, list);
                    check = true;
                    list.remove(list.size() - 1);
                }
            }
        }
        if(!check) answer = Math.max(answer, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        answer = 0;
        ArrayList<Character> list = new ArrayList<>();
        list.add(board[0][0]);
        DFS(0, 0, 1, list);
        System.out.println(answer);

    }
}