package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;

public class Problem_2941 {
    public static void main(String[] args){
        String s = new Scanner(System.in).next();
        s = s.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "a");
        System.out.println(s.length());
    }
}