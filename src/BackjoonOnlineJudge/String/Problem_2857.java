package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2857 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=5; i++) {
            String s = br.readLine();
            if(s.indexOf("FBI") != -1) sb.append(i + " ");
        }
        if(sb.length() == 0) System.out.println("HE GOT AWAY!");
        else System.out.println(sb);
    }
}