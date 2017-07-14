package BackjoonOnlineJudge.Common.Basic;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_6591 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            int n = sc.nextInt();
            int k = sc.nextInt();

            if(n==0 && k==0) break;

            if(k > n-k)
                System.out.println(getFac(n,k).divide(getFac(n-k, 1)));
            else
                System.out.println(getFac(n, n-k).divide(getFac(k, 1)));
        }
    }

    static BigInteger getFac(int n, int k){
        BigInteger mul = new BigInteger("1");
        for(int i=k+1; i<=n; i++)
            mul = mul.multiply(BigInteger.valueOf(i));
        return mul;
    }
}