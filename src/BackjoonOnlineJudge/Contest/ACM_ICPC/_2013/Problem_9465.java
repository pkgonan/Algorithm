package BackjoonOnlineJudge.Contest.ACM_ICPC._2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (--T >= 0){
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[N+1][3];
            int[][] table = new int[N+1][2];

            for(int k=0; k<2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int l=1; l<=N; l++)
                    table[l][k] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++) {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + table[i][1];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + table[i][0];
            }
            System.out.println(Math.max(dp[N][2], Math.max(dp[N][0], dp[N][1])));
        }
    }
}