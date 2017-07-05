package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_10798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character>[] arr = new ArrayList[15];

        for(int i=0; i<15; i++)
            arr[i] = new ArrayList<>();

        for(int i=0; i<5; i++){
            String s = br.readLine();
            for(int j=0; j<s.length(); j++)
                arr[j].add(s.charAt(j));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<15; i++)
            for(char now : arr[i])
                sb.append(now);

        System.out.println(sb);
    }
}