package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int MAX_A = getMax(s[0]);
        int MIN_A = getMin(s[0]);
        int MAX_B = getMax(s[1]);
        int MIN_B = getMin(s[1]);

        System.out.println((MIN_A + MIN_B) + " " + (MAX_A + MAX_B));
    }

    static int getMax(String s){
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<sb.length(); i++)
            if(sb.charAt(i) == '5') sb.setCharAt(i, '6');
        return Integer.parseInt(sb.toString());
    }

    static int getMin(String s){
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<sb.length(); i++)
            if(sb.charAt(i) == '6') sb.setCharAt(i, '5');

        return Integer.parseInt(sb.toString());
    }
}