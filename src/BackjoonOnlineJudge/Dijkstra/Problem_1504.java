package BackjoonOnlineJudge.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1504 {
    static int N, E, M1, M2;
    static ArrayList<Point>[] arr;
    static boolean[] visited;
    static int[] dis;

    public static void main(String[] args) throws IOException{
        init();
        dijkstra(1);
        int oneToM1 = dis[M1];
        int oneToM2 = dis[M2];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dijkstra(M1);
        int M1ToM2 = dis[M2];
        int M1ToN = dis[N];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dijkstra(M2);
        int M2ToM1 = dis[M1];
        int M2ToN = dis[N];
        Arrays.fill(dis, Integer.MAX_VALUE);

        int MAX = Integer.MAX_VALUE;
        if(oneToM1==MAX || M1ToM2==MAX || M2ToN==MAX || oneToM2==MAX || M2ToM1==MAX || M1ToN==MAX)
            System.out.println(-1);
        else{
            int MIN = Math.min(oneToM1 + M1ToM2 + M2ToN , oneToM2 + M2ToM1 + M1ToN);
            System.out.println(MIN);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.w < o2.w) return -1;
                else if(o2.w == o2.w) return 0;
                else return 1;
            }
        });

        pq.add(new Point(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()){
            Point now = pq.poll();

            for(Point next : arr[now.v]){
                if(dis[now.v] + next.w < dis[next.v]){
                    dis[next.v] = Math.min(dis[next.v], dis[now.v] + next.w);
                    pq.add(new Point(next.v, next.w));
                }

            }
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        arr = new ArrayList[N+1];
        dis = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=1; i<=N; i++)
            arr[i] = new ArrayList<>();
        for(int i=1; i<=E; i++) {
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            arr[v1].add(new Point(v2, w));
            arr[v2].add(new Point(v1, w));
        }
        s = br.readLine().split(" ");
        M1 = Integer.parseInt(s[0]);
        M2 = Integer.parseInt(s[1]);
    }

    static class Point{
        int v;
        int w;
        public Point(int v, int w){
            this.v=v; this.w=w;
        }
    }
}