package BackjoonOnlineJudge.Common.BellmanFord;

import java.util.*;

public class Problem_1865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            ArrayList<Pair>[] link = new ArrayList[N+1];
            for(int k=0; k<=N; k++)
                link[k] = new ArrayList<>();

            for(int m=0; m<M; m++){
                st = new StringTokenizer(sc.nextLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                link[E].add(new Pair(S, T));
                link[S].add(new Pair(E, T));
            }

            for(int w=0; w<W; w++){
                st = new StringTokenizer(sc.nextLine(), " ");
                int RS = Integer.parseInt(st.nextToken());
                int RE = Integer.parseInt(st.nextToken());
                int RT = Integer.parseInt(st.nextToken());
                RT *= -1;

                link[RS].add(new Pair(RE, RT));
            }

            System.out.println(getResult(link, M + W));
        }
    }

    static String getResult(ArrayList<Pair>[] link, int N){
        Queue<Integer> q = new LinkedList<>();
        int[] dis = new int[link.length];
        int[] visited = new int[link.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;

        q.add(1);
        boolean isCycle = false;

        while (!q.isEmpty()){
            int now = q.poll();

            for(Pair next : link[now]){
                int next_v = next.v;
                int next_dis = next.dis;

                if(dis[next_v] > dis[now] + next_dis){
                    dis[next_v] = dis[now] + next_dis;
                    q.add(next_v);
                    if(++visited[next_v] == N) isCycle = true;
                }
                if(isCycle) break;
            }
        }
        if(isCycle) return "YES";
        return "NO";
    }

    static class Pair{
        int v, dis;
        public Pair(int v, int dis){
            this.v = v; this.dis = dis;
        }
    }
}