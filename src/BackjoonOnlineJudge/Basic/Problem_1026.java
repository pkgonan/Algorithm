package BackjoonOnlineJudge.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1026 {
    static int N;
    static int[] A, B, A_tmp, B_tmp;

    public static void main(String[] args) throws IOException{
        init();
        start();
    }

    static void start(){
        int len = A_tmp.length;
        int cnt = 0;

        for(int i=0; i<len; i++)
            cnt += (B_tmp[len-i-1] * A_tmp[i]);

        System.out.println(cnt);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        String[] s = br.readLine().split(" ");
        for(int i=0; i<s.length; i++)
            A[i] = Integer.parseInt(s[i]);
        A_tmp = Arrays.copyOf(A, A.length);
        Arrays.sort(A_tmp);

        s = br.readLine().split(" ");
        for(int i=0; i<s.length; i++)
            B[i] = Integer.parseInt(s[i]);
        B_tmp = Arrays.copyOf(B, B.length);
        Arrays.sort(B_tmp);
    }
}