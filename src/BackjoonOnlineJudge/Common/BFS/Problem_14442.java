package BackjoonOnlineJudge.Common.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_14442 {
    static int N,M,K;
    static int[][] map;
    static int[][][] cnt;
    static boolean[][][] visited;
    static int[] xx = { 0,  1,  0, -1 };
    static int[] yy = { 1,  0, -1,  0 };

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getResult());
    }

    static int getResult(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1,1,0));
        cnt[1][1][0] = 1;
        for(int i=0; i<=K; i++)
            visited[1][1][i] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + xx[i];
                int ny = now.y + yy[i];
                int w = now.w;

                if(1<=nx && nx<=N && 1<=ny && ny<=M){
                    if(map[nx][ny] == 0) { //다음꺼가 방이면
                        if(!visited[nx][ny][w]){
                            q.add(new Point(nx, ny, w));
                            visited[nx][ny][w] = true;
                            cnt[nx][ny][w] = cnt[now.x][now.y][w] + 1;
                        }
                    }
                    else{   //다음꺼가 벽이다
                        if(w+1 <= K && !visited[nx][ny][w+1]){
                            q.add(new Point(nx, ny, w+1));
                            visited[nx][ny][w+1] = true;
                            cnt[nx][ny][w+1] = cnt[now.x][now.y][w] + 1;
                        }
                    }
                }
            }
        }
        if(!isMoreThanOneVisited()) return -1;
        else return getMin();

    }

    static boolean isMoreThanOneVisited(){
        for(int i=0; i<=K; i++)
            if(visited[N][M][i]) return true;
        return false;
    }

    static int getMin(){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=K; i++)
            if(visited[N][M][i])
                min = Math.min(min, cnt[N][M][i]);
        return min;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        map = new int[N+1][M+1];
        cnt = new int[N+1][M+1][K+1];
        visited = new boolean[N+1][M+1][K+1];
        for(int i=1; i<=N; i++) {
            String ss = br.readLine();
            for (int j=1; j<=M; j++)
                map[i][j] = Integer.parseInt(String.valueOf(ss.charAt(j-1)));
        }
    }

    static class Point{
        int x, y, w;
        public Point(int x, int y, int w){ this.x=x; this.y=y; this.w=w;}
    }
}