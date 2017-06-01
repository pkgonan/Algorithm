package BackjoonOnlineJudge.Common.DP;

import java.util.Scanner;

public class Problem_11047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];

        for(int i=0; i<N; i++)
            coin[i] = sc.nextInt();

        int coin_cnt = 0;
        for(int i=N-1; i>=0; i--) {
            if (coin[i] <= K) {
                coin_cnt += K / coin[i];
                K %= coin[i];
            }
            if(K == 0) break;
        }

        System.out.println(coin_cnt);
    }
}