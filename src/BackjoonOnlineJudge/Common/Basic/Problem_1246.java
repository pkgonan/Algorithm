package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1246 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[M];
        for(int i=0; i<M; i++)
            arr[i] = sc.nextInt();

        int price = 0, MAX = Integer.MIN_VALUE;

        for (int i=0; i<M; i++) {
            int now = arr[i];
            int cnt = 0;

            for (int j=0; j<M; j++)
                if(now <= arr[j])
                    cnt++;

            if(cnt > N) continue;

            int sum = cnt * now;

            if(MAX < sum){
                price = now;
                MAX = sum;
            }
        }
        System.out.println(price + " " + MAX);
    }
}