package BackjoonOnlineJudge.TopologySort;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem_1516 {
    static int N;
    static int[][] link;
    static int[] time;
    static int[] count;
    static int[] result;
    static LinkedList queue;

    public static void main(String[] args) {
        init();
        printResult();
    }

    static void printResult() {
        while (!queue.isEmpty()) {
            int before = (int) queue.poll();

            for (int i = 1; i <= N; i++) {
                if (link[before][i] == 1) {
                    link[before][i] = 0;
                    result[i] = Math.max(result[i], result[before] + time[i]);
                    if (--count[i] == 0) queue.add(i);
                }
            }
        }
        for (int i = 1; i <= N; i++)
            System.out.println(result[i]);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        link = new int[N + 1][N + 1];
        time = new int[N + 1];
        count = new int[N + 1];
        result = new int[N + 1];
        queue = new LinkedList();

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();

            while (true) {
                int before = sc.nextInt();
                if (before == -1) break;
                if (link[before][i] != 1) {
                    link[before][i] = 1;
                    count[i]++;
                }
            }
            if (count[i] == 0) {
                result[i] = time[i];
                queue.add(i);
            }
        }
    }
}