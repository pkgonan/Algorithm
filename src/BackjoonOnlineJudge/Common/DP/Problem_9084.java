package BackjoonOnlineJudge.Common.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] coin = new int[N];
            for (int i = 0; i < N; i++)
                coin[i] = Integer.parseInt(s[i]);
            int target = Integer.parseInt(br.readLine());

            printResult(N, coin, target);
        }
    }

    static void printResult(int N, int[] coin, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++)
            for (int j = coin[i]; j <= target; j++)
                dp[j] += dp[j - coin[i]];

        System.out.println(dp[target]);
    }
}