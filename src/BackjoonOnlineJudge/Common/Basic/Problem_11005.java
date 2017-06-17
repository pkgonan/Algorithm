package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_11005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(getBinaryNotation(N,B));
    }

    static String getBinaryNotation(int N, int B){
        StringBuilder sb = new StringBuilder();
        char[] alpha = new char[36];
        char ch = 'A';

        for(int i=10; i<36; i++)
            alpha[i] = ch++;

        while (N > 0){
            int n = N % B;
            if(n < 10) sb.append(String.valueOf(N % B));
            else sb.append(String.valueOf(alpha[N % B]));
            N /= B;
        }
        return sb.reverse().toString();
    }
}