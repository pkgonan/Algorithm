package BackjoonOnlineJudge.Common.BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11657 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Line>[] arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            arr[i] = new ArrayList<>();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr[A].add(new Line(B, C));
        }
        bellman_Ford(N, arr);
    }

    static void bellman_Ford(int N, ArrayList<Line>[] arr){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;

        int[] check = new int[N+1];
        boolean isCycle = false;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Line next : arr[now]) {
                int city = next.city;
                int time = next.time;

                if (dis[city] > dis[now] + time) {
                    dis[city] = dis[now] + time;
                    q.add(city);
                    if(++check[city]==N) isCycle = true;
                }
            }
            if(isCycle) break;
        }
        if(isCycle) System.out.println(-1);
        else{
            for(int i=2; i<=N; i++){
                if(dis[i] != Integer.MAX_VALUE) System.out.println(dis[i]);
                else System.out.println(-1);
            }
        }
    }

    static class Line{
        int city, time;
        public Line(int city, int time){
            this.city=city; this.time=time;
        }
    }
}