package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10808 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] cnt = new int[257];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++)
            cnt[s.charAt(i)]++;

        for(int i='a'; i<='z'; i++)
            sb.append(cnt[i] + " ");
        System.out.println(sb);
    }
}