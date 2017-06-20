package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1373 {
    public static void main(String[] args){
        String s = new Scanner(System.in).next();

        int cnt = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sum += Integer.parseInt(String.valueOf(s.charAt(i))) * Math.pow(2.0, cnt++);
            if(cnt == 3 || i==0){
                sb.append(sum);
                sum = cnt = 0;
            }
        }
        System.out.println(sb.reverse());
    }
}