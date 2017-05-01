package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_1010 {
    static long [][] DP = new long[30][30];

    public static void main(String[] args){
        for(int i=1; i<30; i++)
            DP[1][i] = i;

        for(int i=2; i<30; i++){
            for(int j=i; j<30; j++){
                if(i==j) DP[i][j] = 1;
                else DP[i][j] = DP[i][j-1] + DP[i-1][j-1];
            }
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(DP[N][M]);
        }
    }
}