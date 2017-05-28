package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2960 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        getResult(N,K);
    }

    static void getResult(int N, int K){
        int cnt = 0;
        int result = 0;
        boolean[] check = new boolean[N+1];

        for(int i=2; i<=N; i++){
            for(int j=i; j<=N; j = i+j) {
                if (!check[j]) {
                    check[j] = true;
                    if(++cnt == K) {
                        result = j;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}