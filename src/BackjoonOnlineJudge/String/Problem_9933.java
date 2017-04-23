package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_9933 {
    static int N;
    static Map<String, Integer> map;
    static String result;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult() {
        System.out.println(result.length() + " " + result.charAt((result.length()-1) / 2));
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int i=0; i<N; i++) {
            StringBuilder s = new StringBuilder(br.readLine());
            if(!map.containsKey(s.toString())) {
                map.put(s.toString(), 1);
                String ss = s.reverse().toString();
                if(map.containsKey(ss)) map.put(ss, map.get(ss) + 1);
                else map.put(ss, 1);

                if(map.get(s.toString()) == 2) result = s.toString();
            }
            else
                result = s.toString();
        }
    }
}