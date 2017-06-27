package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_3053 {
    public static void main(String[] args){
        int r = new Scanner(System.in).nextInt();
        System.out.printf("%.6f\n%.6f", Math.PI * r * r, r * r * 2.0);
    }
}