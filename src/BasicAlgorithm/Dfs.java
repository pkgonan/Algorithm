package BasicAlgorithm;

public class Dfs {
    int[][] v = {
            {0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0},
            {0,1,0,0,1,1,0,0},
            {0,1,0,0,0,0,1,1},
            {0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0}
    };

    int visit[] = {0,0,0,0,0,0,0,0};
    int MAX = 7;

    void dfs(int start) {
        visit[start] = 1;
        System.out.println(start);
        for (int i = 1; i <= MAX; i++) {
            if (v[start][i] != 0 && visit[i] == 0) {
                dfs(i);
            }
        }
    }
}
