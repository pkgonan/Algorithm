package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1764 {
    static Map<String, Integer> hashmap;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult(){
        System.out.println(list.size());
        Collections.sort(list);
        for(String s : list)
            System.out.println(s);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        hashmap = new HashMap<>();
        list = new ArrayList<>();

        for(int i=0; i<N+M; i++){
            String ss = br.readLine();
            if(!hashmap.containsKey(ss)) hashmap.put(ss, 0);
            else list.add(ss);
        }
    }
}