package BackjoonOnlineJudge.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9663 {
    static int N;
    static int result = 0;
    static boolean[][] queen;

    public static void main(String[] args) throws IOException {
        init();
        queen = new boolean[N + 1][N + 1];
        DFS(1);
        System.out.println(result);
    }

    static void DFS(int i){
        for(int j=1; j<=N; j++){
            if(isNoQueen(i,j)) {
                queen[i][j] = true;
                if(i==N) result++;
                if(i+1 <= N) DFS(i+1);
                queen[i][j] = false;
            }
        }
    }

    static boolean isNoQueen(int i, int j){
        for(int ii=1; ii<=N; ii++)
            if(queen[i][ii] || queen[ii][j]) return false;
        for(int ii=1; ii<=N; ii++)
            if(0<=i-ii&&0<=j-ii && queen[i-ii][j-ii]) return false;
        for(int ii=1; ii<=N; ii++)
            if(i+ii<=N&&j+ii<=N && queen[i+ii][j+ii]) return false;
        for(int ii=1; ii<=N; ii++)
            if(i+ii<=N&&0<=j-ii && queen[i+ii][j-ii]) return false;
        for(int ii=1; ii<=N; ii++)
            if(0<=i-ii&&j+ii<=N && queen[i-ii][j+ii]) return false;
        return true;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new boolean[N+1][N+1];
    }
}
