package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_11057 {
    final static int MOD = 10007;
    int N;
    int[][] M;
    int sum;

    public void getResult(){
        for (int i=0; i<10; i++)
            M[1][i] = 1;

        for(int i=2; i<=N; i++)
            for(int j=0; j<10; j++)
                for(int k=j; k<10; k++)
                    M[i][j] += M[i-1][k] % MOD;
        System.out.println(getSum());
    }

    private int getSum(){
        for(int i=0; i<10; i++)
            sum += M[N][i];
        return sum;
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        M = new int[1001][10];
        sum = 0;
        N = scanner.nextInt();
        scanner.close();
    }

}
