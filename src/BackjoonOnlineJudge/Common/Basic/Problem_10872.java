package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_10872 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        long sum = 1;
        for(int i=N; i>=1; i--) sum *=i;
        System.out.println(sum);
    }
}