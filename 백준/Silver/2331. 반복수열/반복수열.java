import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int p = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(num);
        int answer = find_num(num, p);


        while(true){
            if(arr.contains(answer)){
                System.out.println(arr.indexOf(answer));
                break;
            }
            else{
                arr.add(answer);
            }

            answer = find_num(answer,p);
        }
    }

    public static int find_num(int n, int p){
        int num = 0;
        while(n != 0){
            num += (int) Math.pow(n % 10, p);
            n /= 10;
        }
        return num;
    }

}