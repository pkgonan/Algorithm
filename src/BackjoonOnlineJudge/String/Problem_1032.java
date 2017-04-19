package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1032 {
    static int N;
    static String[] s;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult(){
        StringBuilder sb = new StringBuilder();

        if(N==0) System.out.println(0);
        else {
            for (int i = 0; i < s[0].length(); i++) {
                boolean isSame = true;
                char before = s[0].charAt(i);
                for(int j=1; j<N; j++) {
                    if(before != s[j].charAt(i)) isSame = false;
                    before = s[j].charAt(i);
                }
                if(isSame) sb.append(s[0].charAt(i));
                else sb.append("?");
            }
            System.out.println(sb);
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = new String[N];

        for(int i=0; i<N; i++)
            s[i] = br.readLine();
    }
}