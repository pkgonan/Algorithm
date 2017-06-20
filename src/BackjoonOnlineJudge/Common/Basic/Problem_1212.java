package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1212 {
    public static void main(String[] args){
        int[] bi = { 0, 1, 10, 11, 100, 101, 110, 111 };
        String N = new Scanner(System.in).next();

        System.out.printf("%d", bi[Integer.parseInt(String.valueOf(N.charAt(0)))]);
        for(int i=1; i<N.length(); i++){
            int n = Integer.parseInt(String.valueOf(N.charAt(i)));
            System.out.printf("%03d", bi[n]);
        }
    }
}