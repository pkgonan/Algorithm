package BackjoonOnlineJudge.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2589 {
    public static int MAX = 0;
    public static int N, M;
    public static String[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N][M];
        String s;

        for (int i = 0; i < N; i++) {    //입력 받는 부분
            s = sc.next();
            for (int j = 0; j < M; j++)
                map[i][j] = String.valueOf(s.charAt(j));
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("L")) { //
                    Queue<Data> q = new LinkedList<>();
                    int[][] visited = new int[N][M];
                    int[][] count = new int[N][M];
                    visited[i][j] = 1;
                    q.add(new Data(i, j));
                    BFS(q, visited, count);
                }
            }
        System.out.println(MAX);
    }

    public static void BFS(Queue<Data> q, int[][] visited, int[][] count) {
        while (!q.isEmpty()) {
            Data data = q.poll();
            if (MAX < count[data.x][data.y])
                MAX = count[data.x][data.y];

            for (int i = 0; i < 4; i++) {
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if (promising(nx, ny, q, visited)) {
                    visited[nx][ny] = 1;
                    count[nx][ny] = count[data.x][data.y] + 1;
                    q.add(new Data(nx, ny));
                }
            }
        }
    }

    public static boolean promising(int i, int j, Queue<Data> q, int[][] visited) {
        boolean result = true;
        if (i < 0 || i >= N || j < 0 || j >= M) // 배열의 범위 초과 시
            result = false;
        if (i >= 0 && i < N && j >= 0 && j < M && visited[i][j] == 1) // 이미 방문한 곳일 시
            result = false;
        if (i >= 0 && i < N && j >= 0 && j < M && map[i][j].equals("W")) //땅이 아닐 시
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