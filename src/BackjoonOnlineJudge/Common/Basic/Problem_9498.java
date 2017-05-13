package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_9498 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N / 10 >= 9) System.out.println("A");
        else if(N / 10 == 8) System.out.println("B");
        else if(N / 10 == 7) System.out.println("C");
        else if(N / 10 == 6) System.out.println("D");
        else System.out.println("F");
    }
}