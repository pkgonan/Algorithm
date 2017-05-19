package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_11057 {
    final static int MOD = 10007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N+1][10];

        for(int i=0; i<10; i++)
            dp[1][i]=1;
        for(int i=2; i<=N; i++)
            for(int j=0; j<10; j++)
                for(int k=0; k<=j; k++)
                    dp[i][j] += (dp[i-1][k] % MOD);
        int sum = 0;
        for(int i=0; i<10; i++)
            sum += dp[N][i];
        System.out.println(sum % MOD);
    }
}
