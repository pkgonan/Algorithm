package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            int sum = 0;

            for(int j=0; j<4; j++)
                sum += sc.nextInt();

            if(sum == 4) System.out.println("E");
            else if(sum == 3) System.out.println("A");
            else if(sum == 2) System.out.println("B");
            else if(sum == 1) System.out.println("C");
            else System.out.println("D");
        }
    }
}