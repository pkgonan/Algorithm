package BackjoonOnlineJudge.Common.Samsung;

import java.util.Scanner;

public class Problem_13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1000000];
        int N,B,C;
        long RESULT = 0;

        N = sc.nextInt();
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        for(int i=0; i<N; i++) {
            RESULT++;
            if(arr[i]-B > 0) {
                RESULT += (arr[i]-B)%C != 0? 1 : 0;
                RESULT += (arr[i]-B)/C;
            }
        }
        System.out.println(RESULT);
    }
}