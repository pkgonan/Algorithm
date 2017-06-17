package BackjoonOnlineJudge.Contest.KOI._2004;

import java.util.Scanner;

public class Problem_2609 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long gcd = gcd(a, b);
        long lcm = (a * b) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}