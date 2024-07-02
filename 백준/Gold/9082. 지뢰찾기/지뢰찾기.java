import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] firstRow = new int[N];
            char[] secondRow = new char[N];

            String tmp = sc.next();
            for (int i = 0; i < N; i++) {
                firstRow[i] = Integer.parseInt(String.valueOf(tmp.charAt(i)));
            }

            tmp = sc.next();
            for (int i = 0; i < N; i++) {
                secondRow[i] = tmp.charAt(i);
            }

            System.out.println(findMine(N, firstRow));

        }
    }

    public static int findMine(int N, int[] firstRow) {
        if (N == 1) {
            return firstRow[0];
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 && firstRow[0] != 0 && firstRow[1] != 0) {
                firstRow[0] -= 1;
                firstRow[1] -= 1;
                answer++;
            } else if (i == N - 1 && firstRow[i] != 0 && firstRow[i - 1] != 0) {
                answer++;
            } else if (i > 0 && i < N - 1 && firstRow[i - 1] != 0
                    && firstRow[i] != 0 && firstRow[i + 1] != 0) {
                firstRow[i - 1] -= 1;
                firstRow[i] -= 1;
                firstRow[i + 1] -= 1;
                answer++;
            }
        }
        return answer;
    }
}