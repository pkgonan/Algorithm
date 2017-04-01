package BackjoonOnlineJudge.DP;

import java.util.Scanner;

public class Problem_2096 {
    static int[][][] DP = new int[100000][3][2];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0; i<3; i++)
            DP[0][i][0] = DP[0][i][1] = sc.nextInt();

        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                int tmp = sc.nextInt();
                if(j==0){
                    DP[i][j][0] = Math.max(DP[i-1][j][0] + tmp, DP[i-1][j+1][0] + tmp);
                    DP[i][j][1] = Math.min(DP[i-1][j][1] + tmp, DP[i-1][j+1][1] + tmp);
                }
                else if(j==1){
                    DP[i][j][0] = Math.max(DP[i-1][j-1][0] + tmp, DP[i-1][j][0] + tmp);
                    DP[i][j][0] = Math.max(DP[i-1][j+1][0] + tmp, DP[i][j][0]);

                    DP[i][j][1] = Math.min(DP[i-1][j-1][1] + tmp, DP[i-1][j][1] + tmp);
                    DP[i][j][1] = Math.min(DP[i-1][j+1][1] + tmp, DP[i][j][1]);
                }
                else{
                    DP[i][j][0] = Math.max(DP[i-1][j-1][0] + tmp, DP[i-1][j][0] + tmp);
                    DP[i][j][1] = Math.min(DP[i-1][j-1][1] + tmp, DP[i-1][j][1] + tmp);
                }
            }
        }
        for(int i=0; i<3; i++){
            max = Math.max(max, DP[N-1][i][0]);
            min = Math.min(min, DP[N-1][i][1]);
        }
        System.out.println(max + " " + min);
    }
}