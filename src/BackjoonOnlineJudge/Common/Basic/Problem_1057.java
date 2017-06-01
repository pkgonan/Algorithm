package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1057 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc. nextInt();
        int K = sc.nextInt();
        int Y = sc.nextInt();

        int cnt = 0;

        while (true){
            K = (K&1)==1 ? (K+1)/2 : K/2;
            Y = (Y&1)==1 ? (Y+1)/2 : Y/2;
            cnt++;
            if(K==Y) break;
        }
        if(cnt != 0) System.out.println(cnt);
        else System.out.println(-1);
    }
}