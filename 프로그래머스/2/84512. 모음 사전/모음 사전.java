import java.util.HashMap;

class Solution {
    
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static HashMap<String, Integer> hashMap;
    static int num = 0;

    public void DFS(int L, String current) {

        hashMap.put(current, num++);
        if (L == 5) return;

        for (int i = 0; i < 5; i++) {
            String tmp = current + vowels[i];
            DFS(L + 1, tmp);
        }

    }

    
    
    public int solution(String word) {
        hashMap = new HashMap<>();
        DFS(0, "");
        
        int answer = hashMap.get(word);
        return answer;
    }
}