package BackjoonOnlineJudge.Common.Basic;

import java.util.*;

public class Problem_2412 {
    static int n, T;
    static Pair[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new Pair[n+1];
        arr[0] = new Pair(0,0);
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(sc.nextLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(x,y);
        }
        Arrays.sort(arr);
        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] visit = new int[n+1];
        visit[0] = 1;

        while (!q.isEmpty()){
            int now = q.poll();

            if(arr[now].y == T)
                return visit[now] - 1;

            for(int i=now+1; i<=n; i++){
                if(Math.abs(arr[i].x - arr[now].x) > 2) break;
                if(visit[i] == 0 && Math.abs(arr[i].y - arr[now].y) <= 2){
                    visit[i] = visit[now] + 1;
                    q.add(i);
                }
            }
            for(int i=now-1; i>=0; i--){
                if(Math.abs(arr[i].x - arr[now].x) > 2) break;
                if(visit[i] == 0 && Math.abs(arr[i].y - arr[now].y) <= 2){
                    visit[i] = visit[now] + 1;
                    q.add(i);
                }
            }
        }
        return -1;
    }

    static class Pair implements Comparable<Pair>{
        int x,y;
        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x > o.x) return 1;
            else if(this.x < o.x) return -1;
            else{
                if(this.y > o.y) return 1;
                else if(this.y < o.y) return -1;
                return 0;
            }
        }
    }
}