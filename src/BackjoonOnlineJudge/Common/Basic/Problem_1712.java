package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1712 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(getResult(A, B, C));
    }

    static int getResult(long A, long B, long C){
        int cnt = 0;
        for (int i=1; i<Integer.MAX_VALUE; i++) {
            cnt++;
            if (A + B * i < C * i) return cnt;
        }
        return -1;
    }
}