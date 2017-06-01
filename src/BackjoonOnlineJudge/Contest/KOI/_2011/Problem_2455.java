package BackjoonOnlineJudge.Contest.KOI._2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2455 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 0, cnt = 0;

        for(int i=1; i<=4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            cnt -= out;
            MAX = Math.max(MAX, cnt);
            cnt += in;
            MAX = Math.max(MAX, cnt);
        }

        System.out.println(MAX);
    }
}