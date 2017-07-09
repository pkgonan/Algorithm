package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2439 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        for(int i=1; i<=N; i++){
            for(int j=0; j<N-i; j++)
                System.out.print(" ");
            for(int j=0; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}