package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2839 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();

        int cnt = 0;
        while (N % 5 != 0){
            if(N < 0){
                System.out.println(-1);
                return;
            }
            N -= 3;
            cnt++;
        }
        cnt += N / 5;
        System.out.println(cnt);
    }
}