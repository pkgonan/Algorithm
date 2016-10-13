package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_2169 {
    public static void main(String[] args) {
        int N, M;
        int[][] result;
        int[][] table;
        int[][] left;
        int[][] right;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        table = new int[N+1][M+1];
        result = new int[N+1][M+1];
        left = new int[N+1][M+1];
        right = new int[N+1][M+1];

        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++)
                table[i][j] = sc.nextInt();

        result[1][1] = right[1][1] = table[1][1];
        for(int j=2; j<=M; j++)
            result[1][j] = right[1][j] = table[1][j] + result[1][j-1];

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=M; j++) {   //오른쪽으로 데이터를 쌓아가기(위에서 온 데이터+ 현재 데이터 vs 왼쪽에서 온 데이터 + 현재 데이터)
                if(j-1 >= 1) right[i][j] = Math.max(result[i-1][j] + table[i][j] , right[i][j-1] + table[i][j]);
                else right[i][j] = result[i-1][j] + table[i][j];
            }
            for(int j=M; j>=1; j--) { //왼쪽으로 데이터를 쌓아가기(위에서 온 데이터 + 현재 데이터 vs 오른쪽에서 온 데이터 + 현재 데이터)
                if(j+1 <= M) left[i][j] = Math.max(result[i-1][j] + table[i][j] , left[i][j+1] + table[i][j]);
                else left[i][j] = result[i-1][j] + table[i][j];
            }
            for(int j=1; j<=M; j++) // 왼쪽에서 온 것과 오른쪽에서 온 데이터중 큰 것을 결과 값으로 넣는다
                result[i][j] = Math.max(right[i][j], left[i][j]);
        }
        System.out.println(result[N][M]);
    }
}