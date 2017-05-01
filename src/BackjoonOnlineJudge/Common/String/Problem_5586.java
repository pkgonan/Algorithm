package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5586 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int jcnt=0, icnt=0;

        for(int i=0; i<sb.length()-2; i++){
            String ss = sb.substring(i, i+3);
            if(ss.equals("JOI")) jcnt++;
            if(ss.equals("IOI")) icnt++;
        }

        System.out.println(jcnt);
        System.out.println(icnt);
    }
}