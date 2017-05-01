package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5218 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");

            System.out.print("Distances: ");
            for(int j=0; j<s[0].length(); j++) {
                int num = s[1].charAt(j) - s[0].charAt(j);
                if(num < 0) num = (s[1].charAt(j) + 26) - s[0].charAt(j);
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}