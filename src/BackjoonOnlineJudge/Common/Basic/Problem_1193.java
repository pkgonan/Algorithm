package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1193 {
    public static void main(String[] args){
        int X = new Scanner(System.in).nextInt();

        boolean isUp = true;
        int i=1, j=1, cnt=0;
        while (++cnt < X){
            if(isUp){
                i--;
                j++;
                if(i==0) {
                    i=1;
                    isUp = false;
                }
            }
            else{
                i++;
                j--;
                if(j==0) {
                    j=1;
                    isUp = true;
                }
            }
        }
        System.out.println(i + "/" + j);
    }
}