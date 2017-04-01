package BackjoonOnlineJudge.DP;

import java.util.Scanner;

public class Problem_1912 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int tmp = 0, max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            tmp += n;
            max = Math.max(max, tmp);
            if(tmp < 0) tmp = 0;
        }
        System.out.println(max);
    }
}