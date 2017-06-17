package BackjoonOnlineJudge.Contest.KOI._2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_9613 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int z=1; z<=T; z++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            long[] arr = new long[st.countTokens()];
            int k = 0;
            while (st.hasMoreTokens())
                arr[k++] = Long.parseLong(st.nextToken());

            long sum = 0;
            for(int i=0; i<arr.length; i++)
                for(int j=i+1; j<arr.length; j++)
                    sum += gcd(arr[i], arr[j]);
            System.out.println(sum);
        }
    }

    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}