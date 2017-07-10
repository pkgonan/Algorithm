package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_3062 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            String s = sc.next();
            String rs = new StringBuilder(s).reverse().toString();

            int a = Integer.parseInt(s);
            int b = Integer.parseInt(rs);
            int sum = a + b;

            if(isOk(String.valueOf(sum))) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean isOk(String s){
        for(int i=0; i<s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}