package BackjoonOnlineJudge.Contest.ACM_ICPC.Year_2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int k=1; k<=T; k++){
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];

            if(N>=1) dp[1]=1;
            if(N>=2) dp[2]=1;
            if(N>=3) dp[3]=1;
            if(N>=4) dp[4]=2;
            if(N>=5) dp[5]=2;

            if(N>=6) {
                for (int i = 6; i <= N; i++)
                    dp[i] = dp[i - 1] + dp[i - 5];
            }
            System.out.println(dp[N]);
        }
    }
}