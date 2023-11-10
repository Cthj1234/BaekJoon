import java.util.LinkedList;
import java.util.Scanner;

class Point{
    public int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main{
    static int N,M,len, answer = Integer.MAX_VALUE;
    static LinkedList<Point>home, pizza;
    static int[] combi;

    public static void DFS(int L, int s){

        if(L == M){
            int sum = 0;
            for(int i = 0; i < home.size(); i++){
                int dis = Integer.MAX_VALUE;
                for(int j : combi){
                    dis = Math.min(dis, Math.abs(home.get(i).x - pizza.get(j).x) + Math.abs(home.get(i).y - pizza.get(j).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }else{
            for(int i = s; i < len; i++){
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M= sc.nextInt();
        pizza = new LinkedList<>();
        home = new LinkedList<>();
        combi = new int[M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int tmp = sc.nextInt();
                if(tmp == 1)home.add(new Point(i, j));
                else if (tmp == 2) pizza.add(new Point(i, j));
            }
        }
        len = pizza.size();
        DFS(0, 0);
        System.out.println(answer);
    }
}