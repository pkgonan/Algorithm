package BackjoonOnlineJudge.Common.Basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_2745 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        System.out.println(toDecimal(N, B));
    }

    static int toDecimal(String N, int B){
        int sum = 0;
        char ch = 'A';
        Map<Character, Integer> m = new HashMap<>();
        for(int i=10; i<36; i++)
            m.put(ch++, i);

        for(int i=0; i<N.length(); i++){
            int num;
            if('A' <= N.charAt(i) && N.charAt(i) <= 'Z') num = m.get(N.charAt(i));
            else num = Integer.parseInt(String.valueOf(N.charAt(i)));
            sum += (num * Math.pow(B, N.length()-i-1));
        }
        return sum;
    }
}