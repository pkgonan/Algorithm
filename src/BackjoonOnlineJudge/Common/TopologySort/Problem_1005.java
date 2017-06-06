package BackjoonOnlineJudge.Common.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N+1];
            ArrayList<Integer>[] order = new ArrayList[N+1];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                order[i] = new ArrayList<>();
            }

            int[] indegree = new int[N+1];
            for(int i=1; i<=K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                order[X].add(Y);
                indegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            System.out.println(getMinTime(N,time,order,indegree,W));
        }
    }

    static int getMinTime(int N, int[] time, ArrayList<Integer>[] order, int[] indegree, int W){
        Queue<Integer> q = new LinkedList<>();
        int[] cost = new int[N+1];

        for(int i=1; i<=N; i++)
            if(indegree[i] == 0){
                q.add(i);
                cost[i] = time[i];
            }

        while (!q.isEmpty()){
            int v = q.poll();

            for (int next : order[v]) {
                cost[next] = Math.max(cost[next], cost[v] + time[next]);
                if (--indegree[next] == 0) q.add(next);
            }
        }
        return cost[W];
    }
}