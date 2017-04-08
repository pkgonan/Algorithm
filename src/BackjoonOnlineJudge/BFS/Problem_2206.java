package BackjoonOnlineJudge.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2206 {
    static int N,M;
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
        visited[1][1][0] = visited[1][1][1] = true;
        cnt[1][1][0] = cnt[1][1][1] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + xx[i];
                int ny = now.y + yy[i];
                int w = now.w;

                if(1<=nx && nx<=N && 1<=ny && ny<=M){
                    if(w == 0) { //이전거가 방이다
                        if(map[nx][ny] == 0){ //다음거도 방이다
                            if(!visited[nx][ny][w]) {
                                q.add(new Point(nx, ny, w));
                                visited[nx][ny][w] = true;
                                cnt[nx][ny][w] = cnt[now.x][now.y][w] + 1;
                            }
                        }
                        else {  //다음거는 벽이다
                            if(!visited[nx][ny][w+1]) {
                                q.add(new Point(nx, ny, w+1));
                                visited[nx][ny][w+1] = true;
                                cnt[nx][ny][w+1] = cnt[now.x][now.y][w] + 1;
                            }
                        }
                    }
                    else { //이전거가 벽이다
                        if(map[nx][ny] == 0) { //다음거는 방이네
                            if(!visited[nx][ny][w]) {
                                q.add(new Point(nx, ny, w));
                                visited[nx][ny][w] = true;
                                cnt[nx][ny][w] = cnt[now.x][now.y][w] + 1;
                            }
                        }
                        else { // 다음거도 벽이다
                            continue;
                        }
                    }
                }
            }
        }
        if(!visited[N][M][0] && !visited[N][M][1]) return -1;
        else if(visited[N][M][0] && visited[N][M][1]) return Math.min(cnt[N][M][0], cnt[N][M][1]);
        else if(visited[N][M][0]) return cnt[N][M][0];
        else return cnt[N][M][1];
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N+1][M+1];
        cnt = new int[N+1][M+1][2];
        visited = new boolean[N+1][M+1][2];
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