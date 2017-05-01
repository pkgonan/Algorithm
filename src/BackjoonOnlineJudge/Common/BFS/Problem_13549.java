package BackjoonOnlineJudge.Common.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_13549 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(printResult(N, K));
    }
    static int printResult(int N, int K){
        Queue q = new LinkedList();
        boolean[] visited = new boolean[100001];
        int[] second = new int[100001];
        int min = Integer.MAX_VALUE;
        q.add(N);
        visited[N] = true;

        while(!q.isEmpty()){
            int data = (int)q.poll();

            if(data == K) min = Math.min(min, second[data]);

            if(data-1 >= 0) {
                if (visited[data - 1])
                    second[data - 1] = Math.min(second[data - 1], second[data] + 1);
                else {
                    q.add(data - 1);
                    visited[data - 1] = true;
                    second[data - 1] = second[data] + 1;
                }
            }
            if(data+1 <= 100000) {
                if (visited[data + 1])
                    second[data + 1] = Math.min(second[data + 1], second[data] + 1);
                else{
                    q.add(data + 1);
                    visited[data + 1] = true;
                    second[data + 1] = second[data] + 1;
                }
            }
            if(2*data <= 100000) {
                if (visited[2 * data])
                    second[2 * data] = Math.min(second[2 * data], second[data]);
                else{
                    q.add(2 * data);
                    visited[2 * data] = true;
                    second[2 * data] = second[data];
                }
            }
        }
        return min;
    }
}