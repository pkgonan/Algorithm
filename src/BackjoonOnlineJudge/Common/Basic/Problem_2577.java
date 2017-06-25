package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2577 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long result = sc.nextInt()*sc.nextInt()*sc.nextInt();
        int[] cnt = new int[10];

        while (result > 0){
            cnt[(int)result%10]++;
            result /= 10;
        }

        for(int i=0; i<10; i++)
            System.out.println(cnt[i]);
    }
}