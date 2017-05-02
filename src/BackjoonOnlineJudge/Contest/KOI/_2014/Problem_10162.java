package BackjoonOnlineJudge.Contest.KOI._2014;

import java.util.Scanner;

public class Problem_10162 {
    static int[] time = { 300, 60, 10 };
    static int[] cnt = { 0, 0, 0 };
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<3; i++)
            if(T/time[i] != 0) {
                cnt[i] = T/time[i];
                T %= time[i];
            }
        if(T == 0) System.out.println(cnt[0] + " " + cnt[1] + " " + cnt[2]);
        else System.out.println(-1);
    }
}