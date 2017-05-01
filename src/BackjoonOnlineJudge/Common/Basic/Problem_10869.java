package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10869 {
    static int A,B;

    public static void main(String[] args) throws IOException {
        init();
        printAdd();
        printSub();
        printMul();
        printDiv();
        printMod();
    }

    static void printAdd(){
        System.out.println(A+B);
    }

    static void printSub(){
        System.out.println(A-B);
    }

    static void printMul(){
        System.out.println(A*B);
    }

    static void printDiv(){
        System.out.println(A/B);
    }

    static void printMod(){
        System.out.println(A%B);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
    }
}