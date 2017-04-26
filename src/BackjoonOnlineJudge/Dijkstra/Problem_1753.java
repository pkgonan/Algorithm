package BackjoonOnlineJudge.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1753 {
    static int V, E, K;
    static ArrayList<Point>[] arrayList;
    static int[] min;

    public static void main(String[] args) throws IOException{
        init();
        dijkstra();
    }

    static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.m < o2.m) return -1;
                else if(o1.m == o2.m) return 0;
                else return 1;
            }
        });

        pq.add(new Point(K, 0));
        min[K] = 0;

        while (!pq.isEmpty()){
            Point now = pq.poll();

            for(Point next : arrayList[now.v]){
                if(min[next.v] > min[now.v] + next.m) {
                    min[next.v] = min[now.v] + next.m;
                    pq.add(new Point(next.v, next.m));
                }
            }
        }

        for(int i=1; i<=V; i++) {
            if(min[i] != Integer.MAX_VALUE) System.out.println(min[i]);
            else System.out.println("INF");
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        K = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[V+1];
        min = new int[V+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i=0; i<=V; i++)
            arrayList[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int e = Integer.parseInt(s[2]);
            arrayList[v1].add(new Point(v2, e));
        }
    }

    static class Point{
        int v, m;
        public Point(int v, int m){
            this.v = v; this.m=m;
        }
    }
}