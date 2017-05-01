package BackjoonOnlineJudge.Common.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[s.length];
        int MAX = Integer.MIN_VALUE;

        for(int i=0; i<s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            MAX = Math.max(MAX, arr[i]);
        }

        boolean[] tmp = new boolean[MAX+1];
        tmp[0] = tmp[1] = true;
        for(int i=2; i<=(int)Math.sqrt(MAX); i++)
            for(int j=i+i; j<=MAX; j+= i)
                tmp[j] = true;

        int count = 0;
        for(int i=0; i<s.length; i++)
            if(!tmp[arr[i]]) count++;

        System.out.println(count);
    }
}