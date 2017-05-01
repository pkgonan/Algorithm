package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_2156 {
    int N;
    int[] dp;
    int[] cup;

    public void printResult(){
        dp[1] = cup[1];
        if(N>=2) {
            dp[2] = cup[1] + cup[2];
            for (int i = 3; i <= N; i++)
                dp[i] = MAX(cup[i] + cup[i - 1] + dp[i - 3], cup[i] + dp[i - 2], dp[i - 1]);
        }
        System.out.println(dp[N]);
    }

    private int MAX(int first, int second, int third){
        int max = Math.max(first, second);
        return Math.max(max, third);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new int[N+1];
        cup = new int[N+1];
        for(int i=1; i<=N; i++)
            cup[i] = scanner.nextInt();
        scanner.close();
    }
}