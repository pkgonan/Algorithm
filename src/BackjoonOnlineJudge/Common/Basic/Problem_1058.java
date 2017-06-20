package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1058 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[][] link = new boolean[N+1][N+1];
        for(int i=0; i<N; i++) {
            String name = sc.next();
            for(int j=0; j<N; j++)
                if(name.charAt(j) == 'Y'){
                    link[i+1][j+1] = true;
                    link[j+1][i+1] = true;
                }
        }

        int[] cnt = new int[N+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++){
                if(i==j) continue;
                if(link[i][j]) cnt[i]++;
                else
                    if(isTwoFriend(j, i, N, link)) cnt[i]++;
            }

        int MAX = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++)
            MAX = Math.max(MAX, cnt[i]);

        System.out.println(MAX);
    }

    static boolean isTwoFriend(int j, int before, int N, boolean[][] link){
        for(int k=1; k<=N; k++)
            if(link[j][k] && link[before][k]) return true;
        return false;
    }
}