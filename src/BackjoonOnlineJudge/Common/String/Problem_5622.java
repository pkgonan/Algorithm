package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5622 {
    static String s;
    static int[] ch = new int[257];

    public static void main(String[] args) throws IOException {
        init();
        printResult();
    }

    static void printResult(){
        int time = 0;
        for(int i=0; i<s.length(); i++)
            time += ch[s.charAt(i)];
        System.out.println(time);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        ch['A']=ch['B']=ch['C']=3; ch['D']=ch['E']=ch['F']=4;
        ch['G']=ch['H']=ch['I']=5; ch['J']=ch['K']=ch['L']=6;
        ch['M']=ch['N']=ch['O']=7; ch['P']=ch['Q']=ch['R']=ch['S']=8;
        ch['T']=ch['U']=ch['V']=9; ch['W']=ch['X']=ch['Y']=ch['Z']=10;
    }
}