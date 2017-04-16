package BackjoonOnlineJudge.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1182 {
    static int N, S;
    static int[] num;
    static long cnt = 0;

    public static void main(String[] args) throws IOException{
        init();
        DFS(0, 0);
        if(S == 0) System.out.println(cnt-1);
        else System.out.println(cnt);
    }

    static void DFS(int i, long sum) {
        if(i == N && sum == S) cnt++;
        if(i+1 > N) return;

        DFS(i+1, sum + num[i+1]);
        DFS(i+1, sum);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        num = new int[N+1];
        for(int i=1; i<=N; i++)
            num[i] = Integer.parseInt(s[i-1]);
    }
}