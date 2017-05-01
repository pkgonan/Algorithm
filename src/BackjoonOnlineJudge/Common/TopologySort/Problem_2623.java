package BackjoonOnlineJudge.Common.TopologySort;

import java.util.*;

class Problem_2623 {
    static int[][] link;
    static int[] cnt;
    static int N, M;
    static LinkedList queue;

    public static void main(String[] args){
        init();
        LinkedList result = topologySort();
        if (result.size() < N) System.out.println(0);
        else while (!result.isEmpty())
            System.out.println(result.poll());
    }

    static LinkedList topologySort() {
        LinkedList result = new LinkedList();

        for(int i=1; i<=N; i++)
            if(cnt[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            int before = (int) queue.poll();
            result.add(before);

            for (int i=1; i<=N; i++)
                if(link[before][i] == 1) {
                    link[before][i] = 0;
                    if(--cnt[i] == 0) queue.add(i);
                }
        }
        return result;
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cnt = new int[N+1];
        link = new int[N+1][N+1];
        queue = new LinkedList();
        int before = 0;

        for (int i=1; i<=M; i++) {
            int len = sc.nextInt();

            for (int j=0; j<len; j++) {
                int data = sc.nextInt();
                if (j==0) {
                    before = data;
                } else {
                    if(link[before][data] != 1) {
                        link[before][data] = 1;
                        cnt[data]++;
                    }
                    before = data;
                }
            }
        }
    }
}