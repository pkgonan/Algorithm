package BackjoonOnlineJudge.Common.MST;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem_13418 {
    static int N, M;
    static PriorityQueue<Building> maxPq = new PriorityQueue<>(new BuildingMaxComparator());
    static PriorityQueue<Building> minPq = new PriorityQueue<>(new BuildingMinComparator());

    public static void main(String[] args) {
        init();
        int result = getStress(maxPq) - getStress(minPq);
        System.out.println(result);
    }

    static int getStress(PriorityQueue<Building> pq) {
        UnionFind uf = new UnionFind(M);
        int stressCnt = 0;

        while (!pq.isEmpty()) {
            Building b = pq.poll();
            if(uf.union(b.from, b.to))
                if(b.direction == 0) stressCnt++;
        }
        return stressCnt * stressCnt;
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i <= M; i++) {
            Building building = new Building(sc.nextInt(), sc.nextInt(), sc.nextInt());
            maxPq.add(building);
            minPq.add(building);
        }
    }

    static class BuildingMaxComparator implements Comparator<Building> {
        public int compare(Building a, Building b) {
            if (a.direction < b.direction) return -1;
            else if (a.direction > b.direction) return 1;
            else return 0;
        }
    }

    static class BuildingMinComparator implements Comparator<Building> {
        public int compare(Building a, Building b) {
            if (a.direction < b.direction) return 1;
            else if (a.direction > b.direction) return -1;
            else return 0;
        }
    }

    static class UnionFind{
        int[] level;
        int[] parrent;

        public UnionFind(int length){
            level = new int[length+1];
            parrent = new int[length+1];
            for(int i=1; i<=length; i++) {
                parrent[i] = i;
                level[i] = 1;
            }
        }

        int find(int u){
            if(parrent[u] == u) return u;
            return parrent[u] = find(parrent[u]);
        }

        boolean union(int u, int v){
            u = find(u);
            v = find(v);

            if(u == v) return false;

            if(level[u] > level[v]){
                int tmp = level[u];
                level[u] = level[v];
                level[v] = tmp;
            }
            parrent[u] = v;

            if(level[u] == level[v])
                level[v]++;
            return true;
        }
    }

    static class Building {
        int from;
        int to;
        int direction;

        public Building(int from, int to, int direction) {
            this.from = from;
            this.to = to;
            this.direction = direction;
        }
    }
}