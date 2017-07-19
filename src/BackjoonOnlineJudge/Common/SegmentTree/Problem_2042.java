package BackjoonOnlineJudge.Common.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2042 {
    static int N,M,K;
    static long[] tree, arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new long[N * 4];
        arr = new long[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        init(0, N-1, 1);

        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // Update
            if(a == 1) {
                update(0, N-1, 1, b-1, c-arr[b-1]);
                arr[b-1] = c;
            }
            // Sum
            else
                System.out.println(sum(0, N-1, 1, b-1, c-1));
        }
    }

    static long init(int start, int end, int pos){
        if(start == end) return tree[pos] = arr[start];
        return tree[pos] = init(start, (start+end)/2, pos*2) + init((start+end)/2 + 1, end, pos*2+1);
    }

    static long sum(int start, int end, int pos, int target_l, int target_r){
        if(end < target_l || start > target_r) return 0;
        if(target_l <= start && end <= target_r) return tree[pos];
        return sum(start, (start+end)/2, pos*2, target_l, target_r) + sum((start+end)/2+1, end, pos*2+1, target_l, target_r);
    }

    static void update(int start, int end, int pos, int target, long diff){
        if(start > target || end < target) return;
        if(start <= target && target <= end){
            tree[pos] += diff;
            if(start == end) return;
        }
        update(start, (start+end)/2, pos*2, target, diff);
        update((start+end)/2+1, end, pos*2+1, target, diff);
    }
}