import java.util.Scanner;

class Main{
    static int answer = 0,N;

    public static void DFS(int L, int pay_sum, int time_sum, int[] pay, int[] time){
        if(L > N || time_sum >  N ) return;
        if(L == N){
            answer = Math.max(answer, pay_sum);
        } else{
            DFS(L + time[L], pay_sum + pay[L], time_sum + time[L], pay, time);
            DFS(L + 1, pay_sum, time_sum, pay, time);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] pay = new int[N];
        int[] time = new int[N];

        for(int i = 0; i < N; i++){
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        DFS(0, 0, 0,pay, time);
        System.out.println(answer);
    }
}