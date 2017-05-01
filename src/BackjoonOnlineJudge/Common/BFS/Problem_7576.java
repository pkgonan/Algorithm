package BackjoonOnlineJudge.Common.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_7576 {
    static int M,N;
    static int[][] map;
    static ArrayList<Point> alReadyRed;
    static boolean[][] visited;
    static boolean isAllReded = true, canBeReded = false;
    final static int[] xx = { 1, 0, -1, 0};
    final static int[] yy = { 0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        init();

        if(isAllReded) System.out.println(0);
        else if(!canBeReded) System.out.println(-1);
        else System.out.println(BFS());
    }

    static int BFS(){
        Queue<Point> q = new LinkedList<>();
        for(Point n : alReadyRed) {
            q.add(n);
            visited[n.i][n.j] = true;
        }
        int days = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            days++;
            for(int s=0; s<size; s++) {
                Point now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ni = now.i + yy[i];
                    int nj = now.j + xx[i];

                    if (isPromising(ni, nj) && map[ni][nj] == 0 && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        q.add(new Point(ni, nj));
                    }
                }
            }
        }
        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++)
                if (!visited[i][j] && map[i][j] != -1) return -1;
        return days-1;
    }

    static boolean isPromising(int i, int j){
        if(1>i || i>N || 1>j || j>M) return false;
        return true;
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        alReadyRed = new ArrayList<>();

        for(int i=1; i<=N; i++){
            s = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(s[j-1]);
                if(map[i][j] == 1){
                    canBeReded = true;
                    alReadyRed.add(new Point(i, j));
                }
                if(map[i][j] == 0) isAllReded = false;
            }
        }
    }

    static class Point{
        int i,j;
        public Point(int i, int j){
            this.i=i; this.j=j;
        }
    }
}