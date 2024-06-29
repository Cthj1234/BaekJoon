import java.util.*;

class Solution{
    public int solution(int[][] board){
        int row = board.length;
        int cul = board[0].length;
        int answer = 0;
        if(row < 2 || cul < 2){
            return 1;
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < cul; j++){
                if(board[i][j] == 1){
                    board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        
        return answer * answer;
    }
}