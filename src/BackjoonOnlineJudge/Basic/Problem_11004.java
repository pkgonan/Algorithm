package BackjoonOnlineJudge.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11004 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        Arrays.sort(arr);
        System.out.println(arr[K-1]);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }
}