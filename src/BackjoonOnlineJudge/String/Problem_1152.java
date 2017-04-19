package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1152 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int cnt = 0;

        for(int i=0; i<s.length; i++)
            if(!s[i].equals("")) cnt++;

        System.out.println(cnt);
    }
}