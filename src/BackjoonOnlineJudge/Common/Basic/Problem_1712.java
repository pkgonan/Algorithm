package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1712 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if(B >= C) System.out.println(-1);
        else System.out.println(A / (C-B) + 1);
    }
}