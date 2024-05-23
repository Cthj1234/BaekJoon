import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

    static int N;
    static ArrayList<Integer> list;
    static int[] arr;
    static boolean[] visited;

    public static void DFS(int start, int target){
        if(arr[start] == target) list.add(target);

        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            DFS(arr[start], target);
            visited[arr[start]] = false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        System.out.println(list.size());
        Collections.sort(list);

        for (int x : list) {
            System.out.println(x);
        }
    }


}