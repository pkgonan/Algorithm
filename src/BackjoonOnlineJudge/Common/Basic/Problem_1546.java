package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1546 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 0; double sum = 0;
        for(int i=0; i<N; i++){
            int now = sc.nextInt();
            max = Math.max(max, now);
            sum += now;
        }
        System.out.printf("%.2f", sum/max*100/N);
    }
}