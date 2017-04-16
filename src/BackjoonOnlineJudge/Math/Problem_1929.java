package BackjoonOnlineJudge.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1929 {
    static int M, N;

    public static void main(String[] args) throws IOException{
        init();
        Eratosthenes();
    }

    static void Eratosthenes(){
        boolean[] checked = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        checked[1] = true;

        for(int i=2; i<=(int)Math.sqrt(N); i++){
            for(int j=i+i; j<=N; j += i) {
                checked[j] = true;
            }
        }
        for(int i=M; i<=N; i++)
            if(!checked[i])
                sb.append(i + "\n");
        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
    }
}