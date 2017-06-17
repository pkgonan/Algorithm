package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1934 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println((a * b) / gcd(a,b));
        }
    }

    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}