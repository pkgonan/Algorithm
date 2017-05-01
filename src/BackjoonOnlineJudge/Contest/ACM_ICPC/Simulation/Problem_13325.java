package BackjoonOnlineJudge.Contest.ACM_ICPC.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13325 {
    static int K, CNT, result;
    static int[][] tree;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        int MAX = getMaxWeight(1);
        for(int now=2; now<=CNT/2; now++) {
            int maxWeight = getMaxWeight(now);

            tree[now][now*2] = MAX - maxWeight;
            tree[now][now*2+1] = MAX - maxWeight;

            result += (tree[now][now*2] + tree[now][now*2+1]);
        }
        System.out.println(result);
    }

    static int getMaxWeight(int pos){
        if(pos > CNT) return 0;
        else {
            int left = 0, right = 0;
            if(pos*2 + 1 <= CNT) left = tree[pos][pos*2];
            if(pos*2 + 2 <= CNT) right = tree[pos][pos*2 + 1];

            return Math.max(getMaxWeight(pos*2) + left, getMaxWeight(pos*2 + 1) + right);
        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        CNT = (int)Math.pow(2.0, K+1.0) - 2;
        tree = new int[CNT+2][CNT+2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=CNT/2; i++) {
            tree[i][i*2] = Integer.parseInt(st.nextToken());
            tree[i][i*2+1] = Integer.parseInt(st.nextToken());
        }
    }
}