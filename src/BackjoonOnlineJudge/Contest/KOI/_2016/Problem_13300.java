package BackjoonOnlineJudge.Contest.KOI._2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13300 {
    static int N,K;
    static int[][] stu;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        int cnt = 0;

        for(int i=1; i<=6; i++){
            for(int j=0; j<=1; j++) {
                if (1 <= stu[i][j] && stu[i][j] < K) cnt++;
                else if(stu[i][j] >= K){
                    if(stu[i][j] % K == 0) cnt += (stu[i][j] / K);
                    else cnt += (stu[i][j] / K + 1);
                }
            }
        }
        System.out.println(cnt);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stu = new int[7][2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stu[y][s]++;
        }
    }
}