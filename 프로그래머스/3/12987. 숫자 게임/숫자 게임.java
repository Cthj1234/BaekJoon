import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        
        for(int i = 0; i < A.length; i++){
            if(idx >= A.length) break;
            
            while(B[idx] <= A[i]){
                idx++;
                if(idx >= A.length) break;
            }
            
            if(idx >= A.length) break;
            idx++;
            answer++;
        
        }
        
        return answer;
    }
}