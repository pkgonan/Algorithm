package BackjoonOnlineJudge.Common.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1916 {
    static int N,M,START,END;
    static ArrayList<Point>[] arr;
    static boolean[] visited;
    static int[] min;

    public static void main(String[] args) throws IOException{
        init();
        dijkstra();
        System.out.println(min[END]);
    }

    static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.dis < o2.dis) return -1;
                else if(o1.dis == o2.dis) return 0;
                else return 1;
            }
        });
        min[START] = 0;
        pq.add(new Point(START, min[START]));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            visited[now.vertex] = true;

            for(Point n : arr[now.vertex]){
                if(min[n.vertex] > min[now.vertex] + n.dis){
                    min[n.vertex] = min[now.vertex] + n.dis;
                    pq.add(new Point(n.vertex, n.dis));
                }
            }
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            arr[i] = new ArrayList<>();
        visited = new boolean[N+1];
        min = new int[N+1];
        Arrays.fill(min, Integer.MAX_VALUE);

        for(int i=1; i<=M; i++){
            String[] s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int dis = Integer.parseInt(s[2]);

            arr[v1].add(new Point(v2, dis));
        }
        String[] s = br.readLine().split(" ");
        START = Integer.parseInt(s[0]);
        END = Integer.parseInt(s[1]);
    }

    static class Point{
        int vertex;
        int dis;
        public Point(int vertex, int dis){
            this.vertex=vertex; this.dis=dis;
        }
    }
}