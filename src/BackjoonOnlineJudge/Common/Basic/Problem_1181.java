package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Problem_1181 {
    static int N;
    static PriorityQueue<String> pq;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult(){
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty())
            sb.append(pq.poll() + "\n");

        System.out.print(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if(o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(!set.contains(s)){
                set.add(s);
                pq.add(s);
            }
        }
    }
}