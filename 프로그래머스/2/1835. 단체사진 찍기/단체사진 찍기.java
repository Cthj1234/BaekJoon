import java.util.*;

class Solution {
    static int answer;
    static char[] names = {'A', 'C', 'F', 'J' , 'M', 'N' , 'R' ,'T'};
    static boolean[] visited;
    
    public int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        ArrayList<Character> list = new ArrayList<>();
        DFS(0, n, data, list);
        return answer;
    }

    public void DFS(int idx, int n, String[] data, ArrayList<Character> list) {
        if (idx == 8) {
            if (check(data, list)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(names[i]);
            DFS(idx + 1, n, data, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public boolean check(String[] data, ArrayList<Character> list) {
        for (String str : data) {
            char front = str.charAt(0);
            char back = str.charAt(2);
            char control = str.charAt(3);
            int gap = Integer.parseInt(String.valueOf(str.charAt(4)));
            int betweenGap = Math.abs(list.indexOf(front) - list.indexOf(back)) - 1;

            if (control == '=' && betweenGap != gap) {
                return false;
            } else if (control == '<' && betweenGap >= gap) {
                return false;
            } else if (control == '>' && betweenGap <= gap) {
                return false;
            }
        }
        return true;
    }
}
