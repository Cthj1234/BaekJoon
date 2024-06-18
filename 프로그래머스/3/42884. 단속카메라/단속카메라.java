import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        
        int answer = 0;
        int cur = Integer.MIN_VALUE;
        
        Arrays.sort(routes, new Comparator<int[]> (){
            @Override
            public int compare(int[] route, int[] route2){
                return route[1] - route2[1];
            }
        });
        
        for(int[] route : routes){
            if(cur < route[0]){
                cur = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}