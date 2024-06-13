import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(n > s){
            return new int[] {-1};
        }

        int mod = s % n;
        int avg = s / n;

        Arrays.fill(answer, avg);

        for (int i = 0; i < mod; i++) {
            answer[i] += 1;
        }

        Arrays.sort(answer);


        return answer;
    }
}
