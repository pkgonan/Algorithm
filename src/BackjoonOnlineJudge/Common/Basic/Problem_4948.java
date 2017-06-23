package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_4948 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean[] arr = getSosu();

        while (true){
            int n = sc.nextInt();
            if(n==0) break;

            int num = 0;

            for(int i=n+1; i<=2*n; i++)
                if(!arr[i])
                    num++;

            System.out.println(num);
        }
    }

    static boolean[] getSosu(){
        boolean[] arr = new boolean[250001];

        arr[0] = arr[1] = true;
        for(int i=2; i<=Math.sqrt(250000); i++)
            for(int j=i+i; j<=250000; j=j+i)
                arr[j] = true;
        return arr;
    }
}