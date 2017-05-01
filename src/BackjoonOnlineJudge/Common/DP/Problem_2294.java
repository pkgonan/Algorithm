package BackjoonOnlineJudge.Common.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2294 {
    static int N, K;
    static int[] DP, COIN;
    final static int MAX = 100000000;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        DP[0] = 0;

        for(int i=0; i<N; i++)
            for(int j=0; j<=K; j++)
                if(j>=COIN[i])
                    DP[j] = Math.min(DP[j], DP[j-COIN[i]] + 1);

        if(DP[K] == MAX) System.out.println(-1);
        else System.out.println(DP[K]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        DP = new int[K+1];
        COIN = new int[N];

        for(int i=0; i<N; i++)
            COIN[i] = Integer.parseInt(br.readLine());
        Arrays.fill(DP, MAX);
    }
}