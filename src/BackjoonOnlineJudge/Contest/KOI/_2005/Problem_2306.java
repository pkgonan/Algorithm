package BackjoonOnlineJudge.Contest.KOI._2005;

import java.util.Scanner;

public class Problem_2306 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();

        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int len=2; len<=s.length(); len++){
            for(int start=0; start<=s.length()-len; start++){
                int end = start + len;

                for(int mid=start+1; mid<end; mid++)
                    dp[start][end] = Math.max(dp[start][end], dp[start][mid] + dp[mid][end]);

                if(s.charAt(start) == 'a' && s.charAt(end-1) == 't' || s.charAt(start) == 'g' && s.charAt(end-1) == 'c')
                    dp[start][end] = Math.max(dp[start][end], dp[start+1][end-1] + 2);
            }
        }

        System.out.println(dp[0][s.length()]);
    }
}