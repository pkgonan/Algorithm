package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1568 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sec = 0;
        for(int i=1; i<=1000000000; i++){
            if(N < i) i=0;
            else {
                N -= i;
                sec++;
            }
            if(N==0) break;
        }
        System.out.println(sec);
    }
}