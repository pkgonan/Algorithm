package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11721 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        for(int i=0; i< sb.length(); i+=10){
            if(i+10 < sb.length())
                System.out.println(sb.substring(i, i+10));
            else
                System.out.println(sb.substring(i, sb.length()));
        }
    }
}