package BackjoonOnlineJudge.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2293 {
    static int N, K;
    static int[] DP;
    static int[] coin;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        DP[0] = 1;

        for(int i=0; i<N; i++)
            for(int j=0; j<=K; j++)
                if(j>=coin[i])
                    DP[j] += DP[j-coin[i]];

        System.out.println(DP[K]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        DP = new int[K+1];
        coin = new int[N];

        for(int i=0; i<N; i++)
            coin[i] = Integer.parseInt(br.readLine());
    }
}