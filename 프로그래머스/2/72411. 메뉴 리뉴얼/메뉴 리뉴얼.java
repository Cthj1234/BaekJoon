import java.util.*;

class Solution {


    static boolean[] visited;

    public void DFS(int L, int[] course, String order, HashMap<String, Integer> hashMap) {
        if (L == order.length()) {
            String menu = "";
            for (int i = 0; i < L; i++) {
                if (visited[i]) menu += order.charAt(i);
            }

            if (menu.length() < 2) return;

            for (int tmp : course) {
                if (menu.length() == tmp) {

                    if (!hashMap.containsKey(menu)) {
                        hashMap.put(menu, 1);
                    } else hashMap.put(menu, hashMap.get(menu) + 1);

                }
            }
        } else {
            visited[L] = true;
            DFS(L + 1, course, order, hashMap);
            visited[L] = false;
            DFS(L + 1, course, order, hashMap);

        }
    }

    public List<String> solution(String[] orders, int[] course) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String order : orders) {
            visited = new boolean[order.length()];
            order = stringSort(order);
            DFS(0, course, order, hashMap);
        }

        List<String> list = new ArrayList<>(hashMap.keySet());
        List<String> answer = new ArrayList<>();
        //Hashmap 내림차순 정렬 미구현

        // hashmap 내림차순 정렬

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < course.length; i++) {
            int max = 0;
            for (Map.Entry<String, Integer> entry : entryList) {
                if (entry.getKey().length() == course[i] && entry.getValue() >= 2) {
                    max = Math.max(max, entry.getValue());
                    if (entry.getValue() == max) {
                        answer.add(entry.getKey());
                    }
                }

            }
        }

        Collections.sort(answer);



        return answer;
    }

    private String stringSort(String order) {
        char[] arr = order.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

}