package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_2579 {
    int N;
    int[] stair;
    int[] dp;

    public void printMaxRecord(){
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for(int i=3; i<=N; i++)
            dp[i] = Math.max(stair[i] + dp[i-2] , stair[i] + stair[i-1] + dp[i-3]);
        System.out.println(dp[N]);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        stair = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++)
            stair[i] = scanner.nextInt();
        scanner.close();
    }
}