package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem_10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");

            String order = s[0];
            int cnt = 0;
            if(s.length == 2) cnt = Integer.parseInt(s[1]);

            if(order.equals("push")) q.add(cnt);
            else if(order.equals("front")) {
                if(q.isEmpty()) sb.append(-1).append('\n');
                else sb.append(q.getFirst()).append('\n');
            }
            else if(order.equals("back")) {
                if(q.isEmpty()) sb.append(-1).append('\n');
                else sb.append(q.getLast()).append('\n');
            }
            else if(order.equals("size"))
                sb.append(q.size()).append('\n');
            else if(order.equals("empty")) {
                if(q.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            else if(order.equals("pop")){
                if(q.isEmpty()) sb.append(-1).append('\n');
                else sb.append(q.pollFirst()).append('\n');
            }
        }
        System.out.println(sb);
    }
}