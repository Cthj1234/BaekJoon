import java.util.Objects;

class Solution {

    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        DFS(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;

    }

    public void DFS(String begin, String target, String[] words, int count) {

        if (Objects.equals(begin, target)) {
            answer = Math.min(answer, count);
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (findDifferentCount(begin, words[i]) == 1) {
                visited[i] = true;
                DFS(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }


    }

    public int findDifferentCount(String begin, String word) {

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}