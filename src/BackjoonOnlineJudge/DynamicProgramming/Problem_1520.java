package BackjoonOnlineJudge.DynamicProgramming;

import java.util.Scanner;

public class Problem_1520 {
    int N, M;
    int[][] arr;
    int[][] visited;

    public void printResult() {
        System.out.println(getValueByRecursion(1, 1));
    }

    private int getValueByRecursion(int i, int j) {
        if (i == N && j == M)
            return 1;
        if (visited[i][j] != 0)
            return visited[i][j];
        if (i - 1 >= 0 && arr[i][j] > arr[i - 1][j])
            visited[i][j] += getValueByRecursion(i - 1, j);
        if (i + 1 <= N && arr[i][j] > arr[i + 1][j])
            visited[i][j] += getValueByRecursion(i + 1, j);
        if (j - 1 >= 0 && arr[i][j] > arr[i][j - 1])
            visited[i][j] += getValueByRecursion(i, j - 1);
        if (j + 1 <= M && arr[i][j] > arr[i][j + 1])
            visited[i][j] += getValueByRecursion(i, j + 1);
        return visited[i][j];
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N+1][M+1];
        visited = new int[N+1][M+1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                arr[i][j] = scanner.nextInt();
        scanner.close();
    }
}