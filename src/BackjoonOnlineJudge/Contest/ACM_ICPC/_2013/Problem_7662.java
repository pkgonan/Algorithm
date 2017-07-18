package BackjoonOnlineJudge.Contest.ACM_ICPC._2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_7662 {
    static SortedMap<Long, Long> tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine());

            tree = new TreeMap<>();

            for(int j=0; j<k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String order = st.nextToken();
                long num = Long.parseLong(st.nextToken());

                if(order.equals("I")) {
                    if(!tree.containsKey(num)) tree.put(num, Long.valueOf(1));
                    else tree.put(num, tree.get(num) + 1);
                }
                else {
                    if(tree.isEmpty()) continue;
                    if(num == 1) remove(tree.lastKey());
                    else remove(tree.firstKey());
                }
            }

            if(tree.isEmpty()) System.out.println("EMPTY");
            else System.out.println(tree.lastKey() + " " + tree.firstKey());
        }
    }

    static void remove(Long key){
        if(tree.get(key) == 1) tree.remove(key);
        else tree.put(key, tree.get(key) - 1);
    }
}