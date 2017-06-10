package BackjoonOnlineJudge.Common.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11403 {
    static int N;
    static int[][] arr;
    static final int MAX = 1000000000;

    public static void main(String[] args) throws IOException{
        init();
        floydWarshall();
    }

    static void floydWarshall(){
        for(int k=1; k<=N; k++)
            for(int i=1; i<=N; i++)
                for(int j=1; j<=N; j++)
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (arr[i][j] != MAX) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
            for (int j=1; j<=N; j++)
                arr[i][j] = MAX;

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0) continue;
                arr[i][j] = tmp;
            }
        }
    }
}