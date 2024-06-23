import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cur = 1;
        
        // stations[i] 를 나타낼 때 사용
        int i = 0;
        int len = stations.length;
        
        while(cur <= n){
            if(i < len && cur >= stations[i] - w){
                cur = stations[i] + w + 1;
                i++;
                continue;
            }
            cur += (2 * w) + 1;
            answer ++;
        }
        
        return answer;
    }
}