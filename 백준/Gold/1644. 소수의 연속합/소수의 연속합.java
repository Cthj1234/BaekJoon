import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static int N;
    static ArrayList<Integer> prime = new ArrayList<>();

    public static void getPrime(int n) {
        int[] temp = new int[n + 1];
        int rootN = (int) Math.sqrt(n);
        
        for (int i = 2; i <= n; i++) {
            temp[i] = i;
        }

        for (int i = 2; i <= rootN; i++) {
            if (temp[i] != 0) {
                for (int j = i + i; j <= n; j += i) {
                    temp[j] = 0;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (temp[i] != 0) {
                prime.add(temp[i]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        getPrime(N);

        int lt = 0, rt = 0, answer = 0;
        int sum = 2;
        int size = prime.size();

        while (lt < size) {
            if (sum == N) {
                answer++;
                sum -= prime.get(lt);
                lt++;
            } else if (sum > N) {
                sum -= prime.get(lt);
                lt++;
            }else{
                rt++;
                if(rt >= size) break;
                sum += prime.get(rt);
            }
        }
        System.out.println(answer);
    }
}