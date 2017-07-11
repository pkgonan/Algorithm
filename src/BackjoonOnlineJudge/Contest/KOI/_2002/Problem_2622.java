package BackjoonOnlineJudge.Contest.KOI._2002;

import java.util.Scanner;

public class Problem_2622 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        System.out.println(getCnt(N));
    }

    static int getCnt(int N){
        int cnt = 0;
        for(int i=1; i<N; i++)
            for(int j=i; j<N; j++){
                int next = N-i-j;
                if(j > next) break;
                if(i+j > next)
                    cnt++;
            }
        return cnt;
    }
}