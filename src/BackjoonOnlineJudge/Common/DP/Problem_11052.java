package BackjoonOnlineJudge.Common.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11052 {
    static int N;
    static int[] p, DP;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++){
                if(i>j) continue;
                DP[j] = Math.max(DP[j], DP[j-i] + p[i]);
            }
        System.out.println(DP[N]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        DP = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++)
            p[i] = Integer.parseInt(st.nextToken());
    }
}