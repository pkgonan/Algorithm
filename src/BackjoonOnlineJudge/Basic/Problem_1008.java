package BackjoonOnlineJudge.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1008 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        double A = Double.parseDouble(s[0]);
        double B = Double.parseDouble(s[1]);
        System.out.println(A/B);
    }
}