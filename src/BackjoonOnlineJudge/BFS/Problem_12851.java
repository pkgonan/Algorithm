package BackjoonOnlineJudge.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_12851 {
    static int[] cnt = new int[100001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(getTime(N,K));
        System.out.println(cnt[K]);
    }
    static int getTime(int N, int K){
        Queue q = new LinkedList();
        boolean[] visited = new boolean[100001];
        int[] second = new int[100001];
        int min = Integer.MAX_VALUE;
        q.add(N);
        visited[N] = true;
        cnt[N] = 1;

        while(!q.isEmpty()){
            int data = (int)q.poll();

            if(data == K) min = Math.min(min, second[data]);

            for(int next : new int[]{data-1, data+1, data*2}){
                if(0<= next && next<= 100000){
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                        second[next] = second[data] + 1;
                        cnt[next] = cnt[data];
                    }
                    else if(second[next] == second[data] + 1)
                        cnt[next] += cnt[data];
                }
            }
        }
        return min;
    }
}