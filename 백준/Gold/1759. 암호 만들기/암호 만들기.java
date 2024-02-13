import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int L, C;
    static char[] arr, answer;
    static boolean[] check;

    public static boolean isValid(char[] answer){
        int mo = 0;
        int ja = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u') {
                mo++;
            }else ja++;
        }
        return mo >= 1 && ja >= 2;
    }

    public static void DFS(int N, int checking){
        if (N == L) {
            if (isValid(answer)) {
                System.out.println(answer);
            }
            return;
        }

        for (int i = checking; i < C; i++) {
            answer[N] = arr[i];
            DFS(N + 1, i + 1);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = new char[L];
        arr = new char[C];
        check = new boolean[C];
        String tmp = br.readLine();

        for (int i = 0; i < C; i++) {
            arr[i] = tmp.charAt(2*i);
        }

        Arrays.sort(arr);
        DFS(0,0);
    }
}