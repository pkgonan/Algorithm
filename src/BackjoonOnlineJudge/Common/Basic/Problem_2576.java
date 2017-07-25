package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 7; i++) {
            int num = sc.nextInt();
            if (num % 2 == 1) {
                min = Math.min(min, num);
                sum += num;
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}