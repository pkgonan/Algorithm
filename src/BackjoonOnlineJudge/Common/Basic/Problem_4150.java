package BackjoonOnlineJudge.Common.Basic;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_4150 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();

        BigInteger before = new BigInteger("1");
        BigInteger now = new BigInteger("1");

        for(int i=3; i<=N; i++){
            BigInteger tmp = new BigInteger(before.toString());
            before = now;
            now = tmp.add(now);
        }
        if(N < 1) System.out.println(0);
        else System.out.println(now);
    }
}