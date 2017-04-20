package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Problem_2908 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int A = reverse(Integer.parseInt(s[0]));
        int B = reverse(Integer.parseInt(s[1]));
        System.out.println(Math.max(A, B));
    }

    static int reverse(int num){
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return Integer.parseInt(sb.reverse().toString());
    }
}