class Solution {
    static int[] board;
    static int answer;
    public int solution(int n) {
        answer = 0;

        board = new int[n];
        DFS(0, n);
        return answer;

    }

    private void DFS(int depth, int n) {
        if(depth == n ){
            answer++;
            return;
        }

        for(int i = 0; i < n; i++){
            board[depth] = i;
            if(valid(depth)){
                DFS(depth + 1, n);
            }
        }
    }

    private boolean valid(int i) {
        for (int j = 0; j < i; j++) {
            if(board[i] == board[j]) return false;
            if(Math.abs(i-j) == Math.abs(board[i] - board[j])) return false;
        }
        return true;
    }
}