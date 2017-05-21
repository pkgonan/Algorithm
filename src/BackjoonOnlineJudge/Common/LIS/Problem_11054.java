package BackjoonOnlineJudge.Common.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11054 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp_up = new int[N];
        int[] dp_down = new int[N];
        int[] table = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            table[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            dp_up[i] = 1;
            for(int j=0; j<i; j++)
                if(table[j]<table[i])
                    dp_up[i] = Math.max(dp_up[i], dp_up[j]+1);
        }

        for(int i=N-1; i>=0; i--){
            dp_down[i] = 1;
            for(int j=N-1; j>i; j--)
                if(table[j]<table[i])
                    dp_down[i] = Math.max(dp_down[i], dp_down[j]+1);
        }

        int MAX = 0;
        for(int i=0; i<N; i++)
            MAX = Math.max(MAX, dp_up[i] + dp_down[i] - 1);

        System.out.println(MAX);
    }
}