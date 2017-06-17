package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_2225 {
    static final int MOD = 1000000000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long[][] dp = new long[K+1][N+1];
        dp[0][0] = 1;
        for(int i=1; i<=K; i++)
            for(int j=0; j<=N; j++)
                for(int z=0; z<=j; z++)
                    dp[i][j] += (dp[i-1][j-z]) % MOD;

        System.out.println(dp[K][N] % MOD);
    }
}