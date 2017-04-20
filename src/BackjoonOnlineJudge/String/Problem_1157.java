package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1157 {
    static String s;
    static int[] arr = new int[257];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toUpperCase();
        int MAX = Integer.MIN_VALUE;
        char max = '0';

        for(int i=0; i<s.length(); i++){
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                arr[s.charAt(i)]++;
                if(MAX < arr[s.charAt(i)]){
                    max = s.charAt(i);
                    MAX = arr[s.charAt(i)];
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<arr.length; i++)
            if(arr[i] == MAX) cnt++;

        if(cnt == 1) System.out.println(max);
        else System.out.println("?");
    }
}