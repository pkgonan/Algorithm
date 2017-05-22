package BackjoonOnlineJudge.Contest.ACM_ICPC._2007;

import java.util.Scanner;

public class Problem_1699 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            dp[i]=i;
            for(int j=1; j*j<=i; j++)
                dp[i]=Math.min(dp[i], dp[i-j*j]+1);
        }
        System.out.println(dp[N]);
    }
}