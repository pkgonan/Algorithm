package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1100 {
    final static int N = 8;
    static boolean isWhite = true;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<N; i++){
            String s = br.readLine();

            for(int j=0; j<s.length(); j++) {
                if(isWhite && s.charAt(j) == 'F') cnt++;
                if(j < s.length()-1) isWhite = isWhite? false : true;
            }
        }
        System.out.println(cnt);
    }
}