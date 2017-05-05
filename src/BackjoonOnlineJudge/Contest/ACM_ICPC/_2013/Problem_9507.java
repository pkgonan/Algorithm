package BackjoonOnlineJudge.Contest.ACM_ICPC._2013;

import java.util.Scanner;

public class Problem_9507 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        long[] dp = new long[68];
        dp[0]=dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4; i<=67; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];

        for(int k=1; k<=T; k++){
            int N = sc.nextInt();
            sb.append(dp[N] + "\n");
        }
        System.out.println(sb);
    }
}