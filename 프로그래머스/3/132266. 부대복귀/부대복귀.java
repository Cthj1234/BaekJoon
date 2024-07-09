import java.util.*;

class Solution {
    static int[] cost;
    static List<Integer>[] graph;
    
   public int[] solution(int n, int[][] roads, int[] sources, int destination){
       int[] answer = new int[sources.length];

       cost = new int[n+1];
       Arrays.fill(cost, -1);
       
       graph = new List[n+1];
       for(int i = 0; i <= n; i++){
           graph[i] = new ArrayList();
       }
       
       for(int[] data : roads){
           graph[data[0]].add(data[1]);
           graph[data[1]].add(data[0]);
       }
       
       BFS(destination);
       
       for(int i = 0; i < sources.length; i++){
           answer[i] = cost[sources[i]];
       }
       return answer;
   }
    
    public void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        cost[start] = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int len = graph[cur].size();
            
            for(int i = 0; i < len; i++){
                int next = graph[cur].get(i);
                if(cost[next] == -1){
                    cost[next] = cost[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}