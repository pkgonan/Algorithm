package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10871 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        int X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if(Integer.parseInt(s) < X) sb.append(s + " ");
        }

        System.out.println(sb.toString());
    }
}