package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            String s = Integer.toBinaryString(sc.nextInt());
            for(int j=s.length()-1; j>=0; j--)
                if (s.charAt(j) == '1') System.out.print(s.length()-1-j + " ");
        }
    }
}