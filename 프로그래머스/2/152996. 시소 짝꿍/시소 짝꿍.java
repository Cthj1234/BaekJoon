import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int pre_Value = 0;

        for (int i = 0; i < weights.length - 1; i++) {
            int mid = find_Mid(weights[i], i, weights);
            int count = 0;
            if(i != 0 && weights[i] == weights[i-1]) {
                answer += --pre_Value;
                continue;
            }
            for (int j = i + 1; j <= mid; j++) {
                int tmp = weights[j];
                if (tmp * 3 == weights[i] * 4) {
                    count++;
                }else if(tmp * 2 == weights[i] * 3){
                    count ++;
                }else if(tmp == weights[i] || tmp == 2 * weights[i]) count++;
            }
            answer += count;
            pre_Value = count;
        }


        return answer;
    }

    private int find_Mid(int x, int index, int[] weights) {
        int lt = index;
        int rt = weights.length - 1;
        int mid = 0;

        while (lt < rt) {
            mid = (lt + rt) / 2;
            if (weights[mid] > 2 * x) {
                rt = mid;
            }
            else lt = mid + 1;
        }
        return rt;
    }
}