package BackjoonOnlineJudge.Contest.KOI._2014;

import java.util.Scanner;

public class Problem_10164 {
    static int[][] arr;
    static int N,M,K,target_i,target_j, cnt=0;

    public static void main(String[] args){
        init();
        printResult();
    }

    static void printResult(){
        if(K!=0) {
            getTargetPos(K);
            int t_i = target_i;
            int t_j = target_j;
            DFS(1, 1);
            int first = cnt;
            cnt = 0;

            getTargetPos(N * M);
            DFS(t_i, t_j);
            int second = cnt;

            System.out.println(first * second);
        }
        else{
            getTargetPos(N * M);
            DFS(1, 1);

            System.out.println(cnt);
        }

    }

    static void DFS(int i, int j){
        if(i==target_i && j==target_j) {
            cnt++;
            return;
        }
        else {
            if(1<=i+1 && i+1<=N) DFS(i+1, j);
            if(1<=j+1 && j+1<=M) DFS(i, j+1);
        }
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N+1][M+1];
        int cnt=1;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++) {
                if(cnt==K){
                    target_i = i;
                    target_j = j;
                }
                cnt++;
            }
    }

    static void getTargetPos(int target){
        int cnt=1;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++) {
                if(cnt==target){
                    target_i = i;
                    target_j = j;
                }
                cnt++;
            }
    }
}