package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2581 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        getPrime(M, N);
    }

    static void getPrime(int M, int N){
        boolean[] check = new boolean[N+1];

        for(int i=2; i<=Math.sqrt(N); i++)
            for(int j=i+i; j<=N; j = j+i)
                check[j] = true;

        int sum = 0;
        int min = 0;
        boolean isFirst = true;
        for(int i=2; i<=N; i++) {
            if (!check[i] && M <= i && i <= N) {
                if (isFirst){
                    min = i;
                    isFirst = false;
                }
                sum += i;
            }
        }
        if(sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        }
        else System.out.println(-1);
    }
}