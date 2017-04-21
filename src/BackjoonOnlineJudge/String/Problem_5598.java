package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Problem_5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            if(sb.charAt(i) <= 'C') sb.setCharAt(i, (char) ('Z' - ('A' - (sb.charAt(i) - 3)) + 1));
            else sb.setCharAt(i, (char) ((sb.charAt(i) - 3) % 'Z'));
        }
        System.out.println(sb);
    }
}