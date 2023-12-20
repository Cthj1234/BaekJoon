import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S = new StringBuffer(br.readLine());
        StringBuffer T = new StringBuffer(br.readLine());

        // T가 A로 끝난다 => A를 제거한다.
        // T가 B로 끝난다 => B를 제거하고 뒤집는다.
        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T = T.reverse();
            }
        }

        System.out.println(T.toString().equals(S.toString()) ? 1: 0);

    }
}