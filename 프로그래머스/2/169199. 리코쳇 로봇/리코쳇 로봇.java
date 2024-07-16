import java.util.LinkedList;
import java.util.Queue;

class Node {

    public int x, y, count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {

    static char[][] board;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int R,C;
    static boolean[][] visited;

    public int solution(String[] boards) {
        int answer = 0;
        R = boards.length;
        C = boards[0].length();
        int startX = 0, startY = 0;
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = boards[i];
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                }
            }
        }

        answer = BFS(startX, startY);

        return answer;
    }

    public int BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (board[node.x][node.y] == 'G') {
                return node.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    Node node2 = slideNode(node, i);
                    if (node2 != null) {
                        queue.add(node2);
                    }
                }
            }
        }
        return -1;
    }

    public Node slideNode(Node node, int i) {
        int nx = node.x;
        int ny = node.y;

        while(true){
            nx += dx[i];
            ny += dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C || board[nx][ny] == 'D'){
                if(visited[nx-dx[i]][ny-dy[i]])return null;
                visited[nx-dx[i]][ny-dy[i]] = true;
                return new Node(nx - dx[i], ny - dy[i], node.count + 1);
            }
        }
    }
}

class Main{

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int N = solution.solution(str);
        System.out.println(N);

    }
}