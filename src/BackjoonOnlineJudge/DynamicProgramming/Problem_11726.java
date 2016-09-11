package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_11726 {
    int N;
    int[] M;

    void printResult(){
        for(int i=3; i<=N; i++){
            M[i] = M[i-1] + M[i-2];
            M[i] = M[i] % 10007;
        }
        System.out.println(M[N]);
    }

    void init(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = new int[N+1];
        M[1] = 1;
        M[2] = 2;
        scanner.close();
    }
}
