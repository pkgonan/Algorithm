package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_1463 {
    int[] BUCKET;
    int N;

    public void printMinCount() {
        if (N == 1)
            System.out.println(0);
        else {
            for(int i=2; i<=N; i++) {
                BUCKET[i] = BUCKET[i - 1] + 1;
                if(i%2 == 0 && BUCKET[i] > BUCKET[i/2] + 1)
                    BUCKET[i] = BUCKET[i/2] + 1;
                if(i%3 == 0 && BUCKET[i] > BUCKET[i/3] + 1)
                    BUCKET[i] = BUCKET[i/3] + 1;
            }
            System.out.println(BUCKET[N]);
        }
    }

    private int MIN(int first, int second, int third) {
        int min = (first > second) ? second : first;
        return (min > third) ? third : min;
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        BUCKET = new int[N + 1];
        scanner.close();
    }
}