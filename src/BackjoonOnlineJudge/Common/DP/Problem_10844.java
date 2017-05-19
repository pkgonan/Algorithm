package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_10844 {
    final static int MOD = 1000000000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N+1][10];

        for(int i=1; i<10; i++)
            dp[1][i]=1;

        for(int i=2; i<=N; i++)
            for(int j=0; j<10; j++) {
                if(j==0) dp[i][j] = dp[i-1][j+1];
                else if(j==9) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
                dp[i][j] %= MOD;
            }

        long sum = 0;
        for(int i=0; i<10; i++)
            sum += dp[N][i];

        System.out.println(sum % MOD);
    }
}