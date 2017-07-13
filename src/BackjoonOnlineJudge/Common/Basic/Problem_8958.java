package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_8958 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++)
            System.out.println(getScore(sc.next()));
    }

    static int getScore(String s){
        int sum = 0, score = 0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i) == 'O') sum += ++score;
            else score = 0;
            return sum;
    }
}