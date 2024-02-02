import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }
        if(N < 2){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(board[i][j]);
                }
                if(i == R-1) return;
                System.out.println();
            }
        }

        if(N == 2){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                if(i == R-1) return;
                System.out.println();
            }
        }
        int count = 2;


        while (count <= N) {
            if(count % 2 == 0){
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if(board[i][j] == '.') board[i][j] = '3';
                        else if(board[i][j] == '3') board[i][j] = '1';
                    }
                }
            }else{
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == 'O' || board[i][j] == '1') {
                            board[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] != '.'){
                                    if(board[nx][ny] == 'O' || board[nx][ny] == '1') continue;
                                    board[nx][ny] = '.';
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == '3' || board[i][j] == '1') {
                    System.out.print('O');
                    continue;
                }
                System.out.print(board[i][j]);
            }
            if(i== R-1)return;
            System.out.println();
        }

    }
}