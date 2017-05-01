package BackjoonOnlineJudge.Common.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2178 {
    static int N,M;
    static int[][] arr;
    static int[] xx = { -1,  0,  1,  0 }; // LEFT, DOWN, RIGHT, UP
    static int[] yy = {  0,  1,  0, -1 }; // LEFT, DOWN, RIGHT, UP

    public static void main(String[] args){
        init();
        System.out.println(getResult());
    }

    static int getResult(){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][M+1];
        int[][] cnt = new int[N+1][M+1];
        q.add(new Point(1,1));
        cnt[1][1] = 1;
        visited[1][1] = true;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.x==M && now.y==N) {
                if(cnt[N][M-1] != 0) min = Math.min(min, cnt[N][M-1]);
                if(cnt[N-1][M] != 0) min = Math.min(min, cnt[N-1][M]);
            }

            for(int i=0; i<4; i++){
                int next_x = now.x + xx[i];
                int next_y = now.y + yy[i];

                if(1<=next_x && next_x<=M && 1<=next_y && next_y<=N && !visited[next_y][next_x] && arr[next_y][next_x]==1){
                    q.add(new Point(next_x, next_y));
                    visited[next_y][next_x] = true;
                    cnt[next_y][next_x] = cnt[now.y][now.x] + 1;
                }
            }
        }
        return min + 1;
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][M+1];
        String[] s = new String[N+1];

        for(int i=0; i<=N; i++)
            s[i] = sc.nextLine();

        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++)
                arr[i][j] = Integer.parseInt(String.valueOf(s[i].charAt(j-1)));
    }

    static class Point{
        int x, y;
        public Point(int x, int y){ this.x = x; this.y = y;}
    }
}