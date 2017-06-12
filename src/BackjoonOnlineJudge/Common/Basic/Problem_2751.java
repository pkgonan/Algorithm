package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_2751 {
    static int N;
    static PriorityQueue<Integer> pq;

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
        pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));
    }
}