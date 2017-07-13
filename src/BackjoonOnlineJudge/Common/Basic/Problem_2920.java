package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2920 {
    public static void main(String[] args){
        String[] s = new Scanner(System.in).nextLine().split(" ");

        if(isAscending(s)) System.out.println("ascending");
        else if(isDescending(s)) System.out.println("descending");
        else System.out.println("mixed");
    }

    static boolean isAscending(String[] s){
        for(int i=0; i<s.length-1; i++)
            if(Integer.parseInt(s[i]) > Integer.parseInt(s[i+1]))
                return false;
        return true;
    }

    static boolean isDescending(String[] s){
        for(int i=0; i<s.length-1; i++)
            if(Integer.parseInt(s[i]) < Integer.parseInt(s[i+1]))
                return false;
        return true;
    }
}