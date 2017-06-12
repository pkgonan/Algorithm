package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1427 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        byte[] num = new byte[10];

        while (N > 0){
            num[N%10]++;
            N /= 10;
        }

        StringBuilder sb = new StringBuilder(N+1);
        for(int i=9; i>=0; i--)
            while (num[i]-- != 0)
                sb.append(i);

        System.out.println(sb);
    }
}