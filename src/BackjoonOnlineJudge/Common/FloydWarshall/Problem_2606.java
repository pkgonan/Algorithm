package BackjoonOnlineJudge.Common.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2606 {
    static int N, M;
    static int[][] link;
    static final int MAX = 1000000000;

    public static void main(String[] args) throws IOException{
        init();
        floydWarshall();
    }

    static void floydWarshall(){
        for(int k=1; k<=N; k++)
            for(int i=1; i<=N; i++)
                for(int j=1; j<=N; j++)
                    link[i][j] = Math.min(link[i][j], link[i][k] + link[k][j]);

        int cnt = 0;
        for(int i=2; i<=N; i++)
                if(link[1][i] != MAX) cnt++;

        System.out.println(cnt);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        link = new int[N+1][N+1];

        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                link[i][j] = MAX;

        for(int i=1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            link[A][B] = 1;
            link[B][A] = 1;
        }
    }
}