package BackjoonOnlineJudge.Common.Basic;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem_1158 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        LinkedList<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++)
            q.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (!q.isEmpty()){
            int i=0;
            while(++i<M) q.addLast(q.pollFirst());
            sb.append(q.getFirst()).append(", ");
            q.removeFirst();
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append('>');

        System.out.println(sb);
    }
}