package BackjoonOnlineJudge.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2240 {
    public static int T, W;
    public static int[] tree;
    public static int[][][] dp;
    public static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        T = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);

        tree = new int[T+1];
        dp = new int[T+1][3][W+1];

        for(int i=1; i<=T; i++)
            tree[i] = Integer.parseInt(bf.readLine());

        int result = Math.max(recursion(1,1,0) , recursion(1,2,1));
        System.out.println(result);
    }

    public static int recursion(int second, int pos, int movecount) {
        if(second > T || movecount > W)
            return 0;

        if(dp[second][pos][movecount] != 0)
            return dp[second][pos][movecount];

        else {
            if(tree[second] == pos) {
                dp[second][pos][movecount] =
                        Math.max(recursion(second+1, pos == 1? 1 : 2, movecount) + 1 ,
                                recursion(second+1, pos == 1? 2 : 1, movecount + 1) + 1);
            }
            else {
                dp[second][pos][movecount] =
                        Math.max(recursion(second+1, pos == 1? 1 : 2, movecount) ,
                                recursion(second+1, pos == 1? 2 : 1, movecount + 1));
            }
            return dp[second][pos][movecount];
        }
    }
}