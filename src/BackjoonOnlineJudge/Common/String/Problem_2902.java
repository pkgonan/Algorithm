package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("-");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length; i++)
            sb.append(s[i].charAt(0));
        System.out.println(sb);
    }
}