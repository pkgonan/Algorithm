package BackjoonOnlineJudge.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_12100 {
    static int N;
    static int[][] map;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        init();
        DFS(map, 1);
        System.out.println(MAX);
    }

    static void DFS(int[][] mapp, int cnt){
        if(cnt > 5) return;

        for(int i=0; i<4; i++){
            int[][] tmp = new int[N][N];
            for(int a=0; a<N; a++)
                for(int b=0; b<N; b++)
                    tmp[a][b] = mapp[a][b];

            // 동
            if(i==0) addRight(tmp);
            // 남
            else if(i==1) addDown(tmp);
            // 서
            else if(i==2) addLeft(tmp);
            // 북
            else addhUp(tmp);

            DFS(tmp, cnt+1);
        }
    }

    static void addhUp(int[][] map){
        boolean[][] visited = new boolean[N][N];

        slidingUp(map);

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(map[j-1][i] == map[j][i] && !visited[j-1][i]){
                    visited[j-1][i] = true;
                    map[j-1][i] += map[j][i];
                    MAX = Math.max(MAX, map[j-1][i]);
                    map[j][i] = 0;
                }
            }
        }

        slidingUp(map);
    }

    static void addDown(int[][] map){
        boolean[][] visited = new boolean[N][N];

        slidingDown(map);

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if(map[j+1][i] == map[j][i] && !visited[j+1][i]){
                    visited[j+1][i] = true;
                    map[j+1][i] += map[j][i];
                    MAX = Math.max(MAX, map[j+1][i]);
                    map[j][i] = 0;
                }
            }
        }

        slidingDown(map);
    }

    static void addRight(int[][] map){
        boolean[][] visited = new boolean[N][N];

        slidingRight(map);

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (map[i][j + 1] == map[i][j] && !visited[i][j + 1]) {
                    visited[i][j+1] = true;
                    map[i][j+1] += map[i][j];
                    MAX = Math.max(MAX, map[i][j+1]);
                    map[i][j] = 0;
                }
            }
        }

        slidingRight(map);
    }

    static void addLeft(int[][] map){
        boolean[][] visited = new boolean[N][N];

        slidingLeft(map);

        for(int i=0; i<N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j - 1] == map[i][j] && !visited[i][j - 1]) {
                    visited[i][j-1] = true;
                    map[i][j-1] += map[i][j-1];
                    MAX = Math.max(MAX, map[i][j-1]);
                    map[i][j] = 0;
                }
            }
        }

        slidingLeft(map);
    }

    static void slidingUp(int[][] map){
        for(int a=0; a<N; a++) {
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (map[j - 1][i] == 0) {
                        map[j - 1][i] = map[j][i];
                        map[j][i] = 0;
                    }
                }
            }
        }
    }

    static void slidingDown(int[][] map){
        for(int a=0; a<N; a++) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (map[j+1][i] == 0) {
                        map[j+1][i] = map[j][i];
                        map[j][i] = 0;
                    }
                }
            }
        }
    }

    static void slidingRight(int[][] map){
        for(int a=0; a<N; a++) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (map[i][j+1] == 0) {
                        map[i][j+1] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void slidingLeft(int[][] map){
        for(int a=0; a<N; a++){
            for(int i=0; i<N; i++){
                for(int j=1; j<N; j++){
                    if(map[i][j-1] == 0) {
                        map[i][j-1] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                MAX = Math.max(MAX, map[i][j]);
            }
        }
    }
}