package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2441 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        for(int i=N; i>0; i--){
            for(int j=N; j>i; j--)
                System.out.print(" ");
            for(int j=i; j>0; j--)
                System.out.print("*");
            System.out.println();
        }
    }
}