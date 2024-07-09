import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] board = new int[11][11];
        int[][][][] visited = new int[11][11][11][11];
        int x = 5, y = 5;
        
        int nx = 0, ny = 0;
        for(int i = 0; i < dirs.length(); i++){
            
            char root = dirs.charAt(i);
            
            if(root == 'U'){
                nx = x - 1;
                ny = y;
            }else if (root == 'D'){
                nx = x + 1;
                ny = y;
            }else if(root == 'R'){
                nx = x;
                ny = y + 1;
            }else{
                nx = x;
                ny = y - 1;
            }
            
            if(!(nx >= 0 && nx < 11 && ny >= 0 && ny < 11)) continue;
            
            if(visited[x][y][nx][ny] == 0){
                answer++;
                visited[x][y][nx][ny] = 1;
                visited[nx][ny][x][y] = 1;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}