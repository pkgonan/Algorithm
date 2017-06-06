package BackjoonOnlineJudge.Common.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = " " + br.readLine();
        String s2 = " " + br.readLine();

        int[][] dp = new int[s1.length()][s2.length()];

        for(int i=1; i<s1.length(); i++){
            for(int j=1; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[s1.length()-1][s2.length()-1]);
    }
}