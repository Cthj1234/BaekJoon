import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt = K;

        int mid = (lt + rt)/2;
        int count = 0;

        int answer = 0;
        while(lt <= rt){
            mid = (lt + rt)/2;
            count = 0;

            for(int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            }

            if(count >= K){
                rt = mid - 1;
            }else{
                answer = mid;
                lt = mid +1;
            }

        }
        System.out.println(answer+1);

    }
}