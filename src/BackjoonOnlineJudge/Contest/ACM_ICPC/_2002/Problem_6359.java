package BackjoonOnlineJudge.Contest.ACM_ICPC._2002;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_6359 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            printResult(N);
        }
    }

    static void printResult(int N){
        boolean[] room = new boolean[N+1];
        int cnt=1;

        for(int i=1; i<=N; i++) {
            if(cnt == 1) Arrays.fill(room, true);
            else for(int j=cnt; j<=N; j+=cnt){
                if(room[j]) room[j] = false;
                else room[j] = true;
            }
            cnt++;
        }

        cnt = 0;
        for(int i=1; i<=N; i++)
            if(room[i]) cnt++;
        System.out.println(cnt);
    }
}