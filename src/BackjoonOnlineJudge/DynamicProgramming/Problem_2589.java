package BackjoonOnlineJudge.DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2589 {
    public static int MAX = 0;
    public static int N, M;
    public static String[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N][M];
        String s;

        for (int i = 0; i < N; i++) {
            s = sc.next();
            for (int j = 0; j < M; j++)
                map[i][j] = String.valueOf(s.charAt(j));
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("L")) {
                    Queue<Data> q = new LinkedList<>();
                    int[][] visited = new int[N][M];
                    int[][] count = new int[N][M];
                    visited[i][j] = 1;
                    q.add(new Data(i, j));
                    search(q, visited, count);
                }
            }
        System.out.println(MAX);
    }

    public static void search(Queue<Data> q, int[][] visited, int[][] count) {
        while (!q.isEmpty()) {
            Data data = q.poll();
            if (MAX < count[data.x][data.y])
                MAX = count[data.x][data.y];

            if (promising(data.x - 1, data.y, q, visited)) { //위
                visited[data.x - 1][data.y] = 1;
                count[data.x - 1][data.y] = count[data.x][data.y] + 1;
                q.add(new Data(data.x - 1, data.y));
            }
            if (promising(data.x + 1, data.y, q, visited)) { //아래
                visited[data.x + 1][data.y] = 1;
                count[data.x + 1][data.y] = count[data.x][data.y] + 1;
                q.add(new Data(data.x + 1, data.y));
            }
            if (promising(data.x, data.y - 1, q, visited)) { //왼쪽
                visited[data.x][data.y - 1] = 1;
                count[data.x][data.y - 1] = count[data.x][data.y] + 1;
                q.add(new Data(data.x, data.y - 1));
            }
            if (promising(data.x, data.y + 1, q, visited)) { //오른쪽
                visited[data.x][data.y + 1] = 1;
                count[data.x][data.y + 1] = count[data.x][data.y] + 1;
                q.add(new Data(data.x, data.y + 1));
            }
        }
    }

    public static boolean promising(int i, int j, Queue<Data> q, int[][] visited) {
        boolean result = true;
        if (i < 0 || i >= N || j < 0 || j >= M)
            result = false;
        if (i >= 0 && i < N && j >= 0 && j < M && visited[i][j] == 1)
            result = false;
        if (i >= 0 && i < N && j >= 0 && j < M && map[i][j].equals("W"))
            result = false;
        return result;
    }

    public static class Data {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
