package BackjoonOnlineJudge.Common.Basic;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_10826 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        BigInteger[] num = new BigInteger[10001];
        num[0] = BigInteger.ZERO;
        num[1] = BigInteger.ONE;

        for(int i=2; i<=N; i++)
            num[i] = num[i-1].add(num[i-2]);
        System.out.println(num[N]);
    }
}