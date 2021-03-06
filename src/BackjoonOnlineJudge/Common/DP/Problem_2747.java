package BackjoonOnlineJudge.Common.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2747 {
    static int N;
    static int[] DP;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        DP[0] = 0; DP[1] = 1;

        for(int i=2; i<=N; i++)
            DP[i] = DP[i-1] + DP[i-2];
        System.out.println(DP[N]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
    }
}