package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2440 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        for(int i=N; i>0; i--){
            for(int j=0; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}