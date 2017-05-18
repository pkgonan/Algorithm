package BackjoonOnlineJudge.Common.Basic;

import java.math.BigDecimal;
import java.util.Scanner;

public class Problem_10827 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigDecimal A = sc.nextBigDecimal();
        int B = sc.nextInt();
        System.out.println(A.pow(B).toPlainString());
    }
}