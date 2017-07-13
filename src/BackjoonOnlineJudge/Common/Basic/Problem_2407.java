package BackjoonOnlineJudge.Common.Basic;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_2407 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        getResult(n, m);
    }

    static void getResult(int n, int m){
        BigInteger facN = getFac(n);
        BigInteger facM = getFac(m);
        BigInteger facNM = getFac(n-m);

        BigInteger result = facN.divide(facNM).divide(facM);
        System.out.println(result);
    }

    static BigInteger getFac(int n){
        BigInteger mul = new BigInteger("1");
        for(int i=1; i<=n; i++)
            mul = mul.multiply(BigInteger.valueOf(i));
        return mul;
    }
}