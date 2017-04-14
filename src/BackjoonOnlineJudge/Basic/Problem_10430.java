package BackjoonOnlineJudge.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10430 {
    static int A,B,C;

    public static void main(String[] args) throws IOException{
        init();
        printT1();
        printT2();
        printT3();
        printT4();
    }

    static void printT1(){
        System.out.println((A+B)%C);
    }

    static void printT2(){
        System.out.println((A%C + B%C)%C);
    }

    static void printT3(){
        System.out.println((A*B)%C);
    }

    static void printT4(){
        System.out.println((A%C * B%C)%C);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        C = Integer.parseInt(s[2]);
    }
}