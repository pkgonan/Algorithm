package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String s = br.readLine();
        for(int i=0; i<N; i++)
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        System.out.println(sum);
    }
}