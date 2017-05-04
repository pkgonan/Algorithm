package BackjoonOnlineJudge.Contest.KOI._2016;

import java.util.Scanner;

public class Problem_13301 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];
        dp[1] = 1;
        if(N >= 2)
            for (int i=2; i<=N; i++)
                dp[i] = dp[i-1] + dp[i-2];
        System.out.println(dp[N] * 4 + dp[N-1] * 2);
    }
}