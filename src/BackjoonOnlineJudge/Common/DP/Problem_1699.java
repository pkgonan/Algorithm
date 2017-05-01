package BackjoonOnlineJudge.Common.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1699 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        dp[1] = 1;

        for(int i=2; i<=N; i++){
            double tmp = Math.sqrt(i + 0.0);
            int tmp_int = (int)tmp;
            for(int j=1; j<=tmp_int; j++) {
                if (tmp != tmp_int) {
                    int next = i - j * j;
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[next]);
                } else {
                    dp[i] = Math.min(dp[i], 1);
                }
            }
        }
        System.out.println(dp[N]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }
}