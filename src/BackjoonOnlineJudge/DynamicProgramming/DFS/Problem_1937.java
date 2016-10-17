package BackjoonOnlineJudge.DynamicProgramming.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1937 {
    public static int N;
    public static int[][] forest = new int[501][501];
    public static int[][] dp;
    public static int MAX = 0;
    public static int[] dx = {  1, 0, -1,  0 };
    public static int[] dy = {  0, 1,  0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++)
                forest[i][j] = Integer.parseInt(input[j]);
        }

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                MAX = Math.max(MAX, DFS(i, j));
        System.out.println(MAX + 1);
    }

    public static int DFS(int i, int j) {
        if(i<0 || i>=N || j<0 || j>=N)
            return 0;
        if(dp[i][j] != 0)
            return dp[i][j];
        else {
            for(int k=0; k<4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(nx>=0 && nx<N && ny>=0 && ny<N && forest[i][j] < forest[nx][ny])
                    dp[i][j] = Math.max(dp[i][j], DFS(nx, ny) + 1);
            }
        }
        return dp[i][j];
    }
}