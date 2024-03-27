import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        ArrayList<Integer> pn = new ArrayList<>();
        ArrayList<Integer> nn = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp <= 0) nn.add(tmp);
            else pn.add(tmp);
        }

        Collections.sort(nn);
        pn.sort(Collections.reverseOrder());

        int i = 0;

        while (i < nn.size()) {
            if(i + 1 == nn.size()){
                answer += nn.get(i);
                break;
            }
            if(i + 1 < nn.size()) answer += nn.get(i++) * nn.get(i++);
        }

        i = 0;

        while (i < pn.size()) {
            if (i + 1 < pn.size() && pn.get(i) != 1 && pn.get(i + 1) != 1)
                answer += pn.get(i++) * pn.get(i++);
            else
                answer += pn.get(i++);
        }

        System.out.println(answer);

    }

}