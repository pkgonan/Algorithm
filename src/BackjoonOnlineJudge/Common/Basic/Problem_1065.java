package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1065 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(isOk(i)) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean isOk(int n){
        if(n < 10) return true;
        String s = String.valueOf(n);
        int diff = Integer.parseInt(String.valueOf(s.charAt(1))) - Integer.parseInt(String.valueOf(s.charAt(0)));
        for(int i=0; i<s.length()-1; i++)
            if(Integer.parseInt(String.valueOf(s.charAt(i+1))) - Integer.parseInt(String.valueOf(s.charAt(i))) != diff)
                return false;
        return true;
    }
}