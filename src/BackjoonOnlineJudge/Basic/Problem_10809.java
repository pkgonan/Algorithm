package BackjoonOnlineJudge.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_10809 {
    static String s;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }

        for(int i='a'; i<='z'; i++){
            if(map.containsKey((char)i)) sb.append(map.get((char)i) + " ");
            else sb.append("-1 ");
        }

        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }
}