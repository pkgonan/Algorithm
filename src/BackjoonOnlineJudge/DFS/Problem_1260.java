package BackjoonOnlineJudge.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1260 {
    static int N,M,V;
    static boolean[][] map;
    static boolean[]visited;

    public static void main(String[] args) throws IOException{
        init();
        DFS(V);
        System.out.println();
        BFS();
    }

    static void DFS(int i){
        System.out.print(i + " ");
        visited[i] = true;

        for(int j=1; j<=N; j++){
            if(map[i][j] && !visited[j]){
                visited[j] = true;
                DFS(j);
            }
        }
    }

    static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        q.add(V);
        visited[V] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            System.out.print(now + " ");

            for(int i=1; i<=N; i++){
                if(map[now][i] && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);
        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int ii = Integer.parseInt(s[0]);
            int jj = Integer.parseInt(s[1]);
            map[jj][ii] = map[ii][jj] = true;
        }
    }
}