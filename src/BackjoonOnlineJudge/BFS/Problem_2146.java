package BackjoonOnlineJudge.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int MIN = Integer.MAX_VALUE;
    static int LAND = 1;
    static int[][] LANDARR;
    static Queue resultQ;
    static int[] xx = { 1,   0,  -1,   0 };
    static int[] yy = { 0,   1,   0,  -1 };

    public static void main(String[] args) throws IOException{
        init();
        for(int i=1; i<=N; i++)
            for (int j = 1; j <= N; j++)
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    LAND++;
                }
        BFS2();
        System.out.println(MIN);
    }

    static void BFS2(){
        Queue<Point> ResultQ = resultQ;
        Queue<Point> Q = new LinkedList<>();

        while(!ResultQ.isEmpty()) {
            Point p = ResultQ.poll();
            Q.add(p);
            visited = new boolean[N+1][N+1];
            int[][] cnt = new int[N+1][N+1];
            visited[p.y][p.x] = true;
            int nowland = LANDARR[p.y][p.x];

            while (!Q.isEmpty()) {
                Point now = Q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = now.y + yy[i];
                    int nx = now.x + xx[i];

                    if (1 <= ny && ny <= N && 1 <= nx && nx <= N) {
                        if (map[ny][nx] == 0) {
                            if(!visited[ny][nx]) {
                                Q.add(new Point(ny, nx));
                                cnt[ny][nx] = cnt[now.y][now.x] + 1;
                                visited[ny][nx] = true;
                            }
                        } else {
                            if (LANDARR[ny][nx] != 0 && nowland != LANDARR[ny][nx])
                                MIN = Math.min(MIN, cnt[now.y][now.x]);
                        }
                    }
                }
            }
        }
    }

    static void BFS(int i, int j){
        Queue<Point> Q =new LinkedList<>();
        Q.add(new Point(i,j));
        visited[i][j] = true;
        LANDARR[i][j] = LAND;

        if((j+1<=N && map[i][j+1]==0) ||
                (i+1<=N && map[i+1][j]==0) ||
                (j-1>=1 && map[i][j-1]==0) ||
                (i-1>=1 && map[i-1][j]==-0)){
            resultQ.add(new Point(i, j));
        }

        while(!Q.isEmpty()) {
            Point now = Q.poll();

            for(int a=0; a<4; a++){
                int ny = now.y + yy[a];
                int nx = now.x + xx[a];

                if(1<=nx&&nx<=N && 1<=ny&&ny<=N){
                    if(map[ny][nx]==1 && !visited[ny][nx]) {
                        Q.add(new Point(ny, nx));
                        visited[ny][nx] = true;
                        LANDARR[ny][nx] = LAND;

                        if((nx+1<=N && map[ny][nx+1]==0) ||
                                (ny+1<=N && map[ny+1][nx]==0) ||
                                (nx-1>=1 && map[ny][nx-1]==0) ||
                                (ny-1>=1 && map[ny-1][nx]==-0)){
                            resultQ.add(new Point(ny, nx));
                        }
                    }
                }
            }
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(s[j-1]);
        }
        visited = new boolean[N+1][N+1];
        resultQ = new LinkedList();
        LANDARR = new int[N+1][N+1];
    }

    static class Point{
        int y, x;
        public Point(int y, int x){
            this.y=y; this.x=x;
        }
    }
}