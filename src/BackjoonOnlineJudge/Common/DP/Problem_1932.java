package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_1932 {
    int N;
    int[][] stair;
    int[][] dp;
    int pos;
    int max;

    public void getResult(){
        dp[1][1] = stair[1][1];
        for(int i=2; i<=N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j] + stair[i][j] > dp[i][j]) ? dp[i - 1][j] + stair[i][j] : dp[i][j];
                dp[i][j + 1] = (dp[i - 1][j] + stair[i][j + 1] > dp[i][j + 1]) ? dp[i - 1][j] + stair[i][j + 1] : dp[i][j + 1];
            }
        }
        for(int j=1; j<=N; j++)
            if(max < dp[N][j])
                max = dp[N][j];
        System.out.println(max);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        stair = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        pos = 1;
        max = 0;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=i; j++)
                stair[i][j] = scanner.nextInt();
        scanner.close();
    }
}
