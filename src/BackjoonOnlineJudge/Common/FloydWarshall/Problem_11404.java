package BackjoonOnlineJudge.Common.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11404 {
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        init();
        floydWarshall();
    }

    static void floydWarshall(){
        for(int k=1; k<=N; k++)
            for(int i=1; i<=N; i++)
                for(int j=1; j<=N; j++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++)
                sb.append(dp[i][j]).append(" ");
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
            for (int j=1; j<=N; j++)
                dp[i][j] = (i==j) ? 0 : 1000000000;

        for(int i=1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            dp[A][B] = Math.min(dp[A][B], C);
        }
    }
}