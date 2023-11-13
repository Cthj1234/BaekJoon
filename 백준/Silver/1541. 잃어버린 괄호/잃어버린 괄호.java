import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MIN_VALUE;

        while(st.hasMoreTokens()){
            int tmp = 0;

            //ex) 52-35+23-51+10
            // -> 52-(35+23)-(51+10)
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }
            if(sum == Integer.MIN_VALUE){
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}