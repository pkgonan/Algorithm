package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s  = br.readLine();
        int[] cnt = new int[9];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '9') cnt[6]++;
            else cnt[Integer.parseInt(String.valueOf(s.charAt(i)))]++;
        }
        int MAX = Integer.MIN_VALUE;
        for(int i=0; i<9; i++) {
            if (cnt[i] != 0) {
                if (i == 6) MAX = cnt[i] % 2 == 0  ? Math.max(MAX, cnt[i] / 2) :  Math.max(MAX, cnt[i] / 2 + cnt[i] % 2);
                else MAX = Math.max(MAX, cnt[i]);
            }
        }
        System.out.println(MAX);
    }
}