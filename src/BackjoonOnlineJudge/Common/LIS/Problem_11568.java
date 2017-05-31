package BackjoonOnlineJudge.Common.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        int MAX = 1;

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++)
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            MAX = Math.max(MAX, dp[i]);
        }
        System.out.println(MAX);
    }
}