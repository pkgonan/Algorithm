package BackjoonOnlineJudge.Common.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] table = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            table[i] = Integer.parseInt(st.nextToken());

        int MAX = 1;
        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<i; j++)
                if(table[j] < table[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    MAX = Math.max(MAX, dp[i]);
                }
        }
        System.out.println(MAX);
    }
}