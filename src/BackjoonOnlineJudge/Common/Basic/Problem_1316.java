package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_1316 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        for(int i=0; i<N; i++)
            if(isOk(sc.next())) cnt++;

        System.out.println(cnt);
    }

    static boolean isOk(String s){
        boolean[] check = new boolean['z'+1];

        char before = s.charAt(0);
        for(int j=0; j<s.length(); j++){
            if(before != s.charAt(j) && check[s.charAt(j)]) return false;
            else check[s.charAt(j)] = true;
            before = s.charAt(j);
        }
        return true;
    }
}