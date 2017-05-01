package BackjoonOnlineJudge.Common.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem_1261 {
    static int M,N;
    static int[][] arr;
    static int[][] cnt;
    static int[] xx = { 1,  0, -1,  0 };
    static int[] yy = { 0,  1,  0, -1 };

    public static void main(String[] args){
        init();
        System.out.println(getMin());
    }

    static int getMin(){
        PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.data < o2.data) return -1;
                else if(o2.data == o2.data) return 0;
                else return 1;
            }
        });
        q.add(new Point(1,1, arr[1][1]));

        while(!q.isEmpty()) {
            Point now = q.poll();

            for(int i=0; i<4; i++) {
                int next_x = now.x + xx[i];
                int next_y = now.y + yy[i];

                if(1<=next_x && next_x<=N && 1<=next_y && next_y<=M && cnt[now.x][now.y] + arr[next_x][next_y] < cnt[next_x][next_y]){
                    q.add(new Point(next_x, next_y, arr[next_x][next_y]));
                    cnt[next_x][next_y] = cnt[now.x][now.y] + arr[next_x][next_y];
                }
            }
        }
        return cnt[N][M];
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N+1][M+1];
        cnt = new int[N+1][M+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++)
                cnt[i][j] = Integer.MAX_VALUE;
        cnt[1][1] = 0;
        String[] s = new String[N+1];
        for(int i=0; i<=N; i++) s[i] = sc.nextLine();
        for(int i=1; i<=N; i++)
            for(int j=0; j<M; j++)
                arr[i][j+1] = Integer.parseInt(String.valueOf(s[i].charAt(j)));
    }

    static class Point{
        int x, y, data;
        public Point(int x, int y, int data) { this.x = x; this.y = y; this.data = data;}
    }
}