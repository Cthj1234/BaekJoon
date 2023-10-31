import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{

    public int friend_num, empty_num,r,c;

    public Point(int friend_num, int empty_num,int r, int c){
        this.friend_num = friend_num;
        this.empty_num = empty_num;
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Point o) {
        // Friend_num이 큰 순서로 정렬, empty_num이 큰 순서로 정렬
        if (this.friend_num != o.friend_num) {
            return Integer.compare(o.friend_num, this.friend_num);
        } else if (this.empty_num != o.empty_num) {
            return Integer.compare(o.empty_num, this.empty_num);
        } else {
            if (this.r != o.r) {
                return Integer.compare(this.r, o.r);
            } else {
                return Integer.compare(this.c, o.c);
            }
        }
    }
}

class Main{

    static int N;
    // 상,하,좌,우 순
    static int[] dx = {0,0,-1,1}, dy = {1, -1, 0, 0};

    // 학생별 선호도
    static HashMap<Integer, int[]> map = new HashMap<>();
    static int[] student;
    //좌석
    static int[][] Seat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Point> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        Seat = new int[N][N];

        // 리스트 입력
        for(int x = 0; x < N * N; x++){
            st = new StringTokenizer(br.readLine());
            int student_num = Integer.parseInt(st.nextToken());
            student =new int[4];
            for(int j = 0; j < 4; j++){
                student[j] = Integer.parseInt(st.nextToken());
            }
            map.put(student_num, student);

            list.clear();;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int friend_num = 0;
                    int empty_num = 0;

                    if(Seat[i][j] !=0) continue;
                    int[] tmp_list = new int[4];
                    tmp_list = map.get(student_num);

                    for(int k = 0; k < 4; k++){
                        if(i + dx[k] >= 0 && j + dy[k] >= 0 && i+dx[k] < N && j+dy[k] <N){
                            for(int tmp : tmp_list){
                                if (tmp == Seat[i + dx[k]][j + dy[k]]){
                                    friend_num++;
                                    break;
                                }
                                else if (Seat[i + dx[k]][j + dy[k]] == 0) {
                                    empty_num++;
                                    break;
                                }
                            }
                        }
                    }
                    list.add(new Point(friend_num,empty_num,i,j));
                }
            }
            Collections.sort(list);
            Point o = list.get(0);
            Seat[o.r][o.c] = student_num;
        }

        double answer = 0;




            /*list.clear();;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int friend_num = 0;
                    int empty_num = 0;

                    if(Seat[i][j] !=0) continue;
                    int[] tmp_list = new int[4];
                    tmp_list = map.get(x);

                    for(int k = 0; k < 4; k++){
                        if(i + dx[k] >= 0 && j + dy[k] >= 0 && i+dx[k] < N && j+dy[k] <N){
                            for(int tmp : tmp_list){
                                if (tmp == Seat[i + dx[k]][j + dy[k]]){
                                    friend_num++;
                                    break;
                                }
                                else if (Seat[i + dx[k]][j + dy[k]] == 0) {
                                    empty_num++;
                                    break;
                                }
                            }
                        }
                    }
                    list.add(new Point(friend_num,empty_num,i,j));
                }
            }
            Collections.sort(list);
            Point o = list.get(0);
            Seat[o.r][o.c] = x;*/


            int[] tmp_list = new int[4];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int count = 0;
                    //tmp_list = 선호 하는 학생의 목록
                    tmp_list = map.get(Seat[i][j]);
                    for(int k = 0; k < 4; k++){
                        if(i + dx[k] >= 0 && j + dy[k] >= 0 && i+dx[k] < N && j+dy[k] <N){
                            for(int tmp : tmp_list){
                                if(tmp == Seat[i + dx[k]][j + dy[k]] )count ++;
                            }
                        }
                }
                    if(count > 0) answer += Math.pow(10, count - 1);
            }
        }
        System.out.println((int)answer);
    }
}