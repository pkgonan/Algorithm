package BackjoonOnlineJudge.Common.DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1717 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(N);
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(f == 0) uf.union(a,b);
            else {
                if(uf.isUnionable(a,b)) sb.append("NO\n");
                else sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }

    static class UnionFind{
        int[] level, parrent;

        public UnionFind(int N){
            level = new int[N+1];
            parrent = new int[N+1];

            Arrays.fill(level, 1);
            for(int i=1; i<=N; i++)
                parrent[i] = i;
        }

        public int find(int n){
            if(parrent[n]==n) return n;
            return parrent[n] = find(parrent[n]);
        }

        public boolean isUnionable(int a, int b){
            a = find(a);
            b = find(b);

            if(a == b) return false;
            return true;
        }

        public boolean union(int a, int b){
            a = find(a);
            b = find(b);

            if(a == b) return false;
            if(level[a] < level[b]){
                int tmp = a;
                a = b;
                b = tmp;
            }
            parrent[b] = a;
            if(level[a] == level[b])
                level[a]++;
            return true;
        }
    }
}