package BackjoonOnlineJudge.Common.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_14226 {
    static int S, MIN = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        BFS();
    }

    static void BFS(){
        Queue<A> Q = new LinkedList();
        Q.add(new A(1, 0, 0));
        visited[1][0] = true;

        while(!Q.isEmpty()) {
            A now = Q.poll();

            if(now.M == S) MIN = Math.min(MIN, now.T);

            if(now.M < S) {
                if(now.T+1 <= S) {
                    if(now.M != now.C && !visited[now.M][now.M]) {
                        Q.add(new A(now.M, now.M, now.T+1));
                        visited[now.M][now.M] = true;
                    }

                    if (now.C != 0 && now.M+now.C <= S && !visited[now.M+now.C][now.C]) {
                        Q.add(new A(now.M+now.C, now.C, now.T+1));
                        visited[now.M+now.C][now.C] = true;
                    }

                    if (now.M-1 >= 1 && now.T+1 < MIN && !visited[now.M-1][now.C]) {
                        Q.add(new A(now.M-1, now.C, now.T+1));
                        visited[now.M-1][now.C] = true;
                    }
                }
            }
            else {
                if(now.T+1 <= S) {
                    if (now.M-1 >= 1 && now.T+1 < MIN && !visited[now.M-1][now.C]) {
                        Q.add(new A(now.M-1, now.C, now.T+1));
                        visited[now.M-1][now.C] = true;
                    }
                }
            }
        }
        System.out.println(MIN);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[S+1][S+1];
    }

    static class A {
        int M, C, T;
        public A(int M, int C, int T) { this.M = M; this.C = C; this.T = T; }
    }
}