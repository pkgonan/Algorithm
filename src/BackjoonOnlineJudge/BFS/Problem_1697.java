package BackjoonOnlineJudge.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1697 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(printResult(N, K));
    }
    static int printResult(int N, int K){
        Queue q = new LinkedList();
        int[] visited = new int[100001];
        int[] second = new int[100001];
        int min = Integer.MAX_VALUE;
        q.add(N);
        visited[N] = 1;

        while(!q.isEmpty()){
            int data = (int)q.poll();

            if(data == K) min = Math.min(min, second[data]);

            if(data-1 >= 0 && visited[data-1] == 0) {
                q.add(data-1);
                visited[data-1] = 1;
                second[data-1] = second[data] + 1;
            }
            if(data+1 <= 100000 && visited[data+1] == 0) {
                q.add(data+1);
                visited[data+1] = 1;
                second[data+1] = second[data] + 1;
            }
            if(2*data <= 100000 && visited[2*data] == 0) {
                q.add(2*data);
                visited[2*data] = 1;
                second[2*data] = second[data] + 1;
            }
        }
        return min;
    }
}