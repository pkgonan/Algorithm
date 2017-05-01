package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_2789 {
    final static char[] ch = {'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};
    static StringBuilder sb;
    static Map<Character, Boolean> map;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult(){
        for(int i=0; i<sb.length(); i++) {
            if (map.containsKey(sb.charAt(i))) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(sb.toString());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(br.readLine());
        map = new HashMap<>();

        for(int i=0; i<ch.length; i++)
            map.put(ch[i], true);
    }
}