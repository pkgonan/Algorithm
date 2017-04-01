package BackjoonOnlineJudge.DP;

import java.util.Scanner;

public class Problem_9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] DP = new int[11];
        DP[1] = 1; DP[2] = 2; DP[3] = 4;
        for(int i=4; i<=10; i++)
            DP[i] = DP[i-1] + DP[i-2] + DP[i-3];

        int T = sc.nextInt();
        for(int i=0; i<T; i++)
            System.out.println(DP[sc.nextInt()]);
    }
}