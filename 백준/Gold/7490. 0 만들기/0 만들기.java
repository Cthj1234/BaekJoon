import java.util.Scanner;

class Main{
    static int num;
    static StringBuilder sb;

    public static void DFS(int L, int sum, String str) {
        if (L > num) {
            return;
        }
        if (num == L && sum == 0) {
            sb.append(str).append("\n");
            return;
        }

        
        // 1 2+3+4 이럴 경우
        if (L == 1) {
            DFS(2, 12, "1 2");
        }

        if (str.length() >= 3) {
            char ch = str.charAt(str.length() - 2);
            int tmp = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));
            if (ch == '-') {
                tmp = 9 * tmp + L + 1;
                DFS(L + 1, sum - tmp, str + " " + String.valueOf(L + 1));
            } else if (ch == '+') {
                tmp = 9 * tmp + L + 1;
                DFS(L + 1, sum + tmp, str + " " + String.valueOf(L + 1));
            }
        }

        DFS(L + 1, sum + L + 1, str + "+" + String.valueOf(L + 1));
        DFS(L + 1, sum - (L + 1), str + "-" + String.valueOf(L + 1));




    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int N = sc.nextInt();
        while (N-- > 0) {
            num = sc.nextInt();
            DFS(1, 1,"1");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}