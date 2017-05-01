package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_1003 {
    static int[][] DP = new int[41][2];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        DP[0][0] = 1; DP[0][1] = 0;

        for(int i=1; i<=40; i++){
            DP[i][0] = DP[i-1][1];
            DP[i][1] = DP[i-1][0] + DP[i-1][1];
        }

        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            System.out.println(DP[N][0] + " " + DP[N][1]);
        }
    }
}