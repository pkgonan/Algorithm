package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_2133 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        long[] dp = new long[N+1];

        dp[0]=1;
        for(int i=2; i<=N; i+=2) {
            dp[i] = 3 * dp[i-2];
            for (int j=0; j<=i-4; j += 2)
                dp[i] += 2 * dp[j];
        }
        System.out.println(dp[N]);
    }
}