package BackjoonOnlineJudge.DP;

import java.util.Scanner;

public class Problem_2602 {
    String target, devil, angel;
    int[] devilDp, angelDp;
    int N, MAX;

    public void printResult() {
        System.out.println(recursion(0, 0, 0) + recursion(1, 0, 0));
    }

    private int recursion(int flag, int j, int k) {
        int temp = 0;
        int tmp;
        if (k == MAX)
            return 1;
        if(j >= N)
            return temp;
        if (flag == 0 && devilDp[j] != 0)
            return devilDp[j];
        else if(flag == 1 && angelDp[j] != 0)
            return angelDp[j];
        for (int i = j; i < N; i++) {
            if (flag == 0 && devil.charAt(i) == target.charAt(k)) {
                tmp = recursion(1, i + 1, k + 1);
                temp += tmp;
                devilDp[i] += tmp;
            }
            else if (flag == 1 && angel.charAt(i) == target.charAt(k)) {
                tmp = recursion(0, i + 1, k + 1);
                temp += tmp;
                angelDp[i] += tmp;
            }
        }
        return temp;
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        target = scanner.next();
        devil = scanner.next();
        angel = scanner.next();
        N = devil.length();
        MAX = target.length();
        devilDp = new int[devil.length()];
        angelDp = new int[angel.length()];
        scanner.close();
    }
}