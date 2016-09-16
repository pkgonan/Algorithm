package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_11048 {
    int N, M;
    int[][] arr, dp;

    public void printValue(){
        dp[1][1] = arr[1][1];
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <=M; j++) {
                if(i < N && dp[i][j] + arr[i+1][j] > dp[i+1][j]) dp[i+1][j] = dp[i][j] + arr[i+1][j];
                if(j < M && dp[i][j] + arr[i][j+1] > dp[i][j+1]) dp[i][j+1] = dp[i][j] + arr[i][j+1];
                if(i < N && j < M && dp[i][j] + arr[i+1][j+1] > dp[i+1][j+1]) dp[i+1][j+1] = dp[i][j] + arr[i+1][j+1];
            }
        }
        System.out.println(dp[N][M]);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr =  new int[N+1][M+1];
        dp =  new int[N+1][M+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++)
                arr[i][j] = scanner.nextInt();
        scanner.close();
    }
}