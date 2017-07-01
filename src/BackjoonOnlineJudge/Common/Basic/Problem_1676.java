package BackjoonOnlineJudge.Common.Basic;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_1676 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        BigInteger num = new BigInteger("1");

        for(int i=N; i>=1; i--)
            num = num.multiply(BigInteger.valueOf(i));

        int cnt = 0;
        while (num.compareTo(BigInteger.ZERO) == 1){
            if(num.mod(BigInteger.TEN).equals(BigInteger.ZERO)) cnt++;
            else break;
            num = num.divide(BigInteger.valueOf(10));
        }
        System.out.println(cnt);
    }
}