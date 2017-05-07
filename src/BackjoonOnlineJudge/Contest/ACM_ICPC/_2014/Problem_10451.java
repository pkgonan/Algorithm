package BackjoonOnlineJudge.Contest.ACM_ICPC._2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_10451 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[] tmp = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
                arr[1][j] = tmp[j];
            }
            Arrays.sort(tmp);
            for(int j=0; j<N; j++)
                arr[0][j] = tmp[j];

            UnionFind unionFind = new UnionFind(N);
            int cnt = 0;

            for(int j=0; j<N; j++)
                if(!unionFind.union(arr[0][j], arr[1][j]))
                    cnt++;

            System.out.println(cnt);
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
}