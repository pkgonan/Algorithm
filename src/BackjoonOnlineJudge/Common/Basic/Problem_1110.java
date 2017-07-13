package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1110 {
    public static void main(String[] args){
        String N = new Scanner(System.in).next();

        if(Integer.parseInt(N) < 10)
            N = "0" + N;

        int cnt = 0;
        String s = new String(N);
        while (cnt++ < 99){
            String first = String.valueOf(s.charAt(s.length()-1));
            String last = getLast(s);

            s = new String(first + last);
            if(N.equals(s))
                break;
        }
        System.out.println(cnt);
    }

    static String getLast(String s){
        int sum = 0;
        for(int i=0; i<s.length(); i++)
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        return String.valueOf(sum % 10);
    }
}