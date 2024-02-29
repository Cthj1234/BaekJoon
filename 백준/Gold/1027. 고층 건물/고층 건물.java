import java.util.Scanner;

class Main{
    static int N;
    static int[] arr;

    public static int count(int idx){
        int count = 0;
        double tmp = Integer.MAX_VALUE;

        for (int i = idx - 1; i >= 0; i--) {
            double slope = (double)(arr[idx] - arr[i]) / (idx - i);
            if(slope < tmp){
                tmp = slope;
                count++;
            }
        }

        tmp = Integer.MIN_VALUE;

        for (int i = idx + 1; i < N; i++) {
            double slope = (double) (arr[idx] - arr[i]) / (idx - i);
            if(slope > tmp){
                tmp = slope;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int answer = 0;

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, count(i));
        }

        System.out.print(answer);

    }
}