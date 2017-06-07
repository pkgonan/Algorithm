package BackjoonOnlineJudge.Common.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2252 {
    static int N,M;
    static ArrayList<Integer>[] arr;
    static int[] cnt;

    public static void main(String[] args) throws IOException{
        init();
        printResult();
    }

    static void printResult(){
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++)
            if(cnt[i] == 0) q.add(i);

        while (!q.isEmpty()){
            int now = q.poll();
            sb.append(now + " ");

            for(int next : arr[now])
                if(--cnt[next] == 0) q.add(next);
        }
        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        cnt = new int[N+1];
        for(int i=1; i<=N; i++)
            arr[i] = new ArrayList<>();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
            cnt[B]++;
        }
    }
}