package BackjoonOnlineJudge.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem_1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Boolean> hashMap = new HashMap();

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        for(int i=0; i<N; i++)
            hashMap.put(Integer.parseInt(s[i]), true);

        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            if(hashMap.containsKey(Integer.parseInt(s[i]))) System.out.println(1);
            else System.out.println(0);
        }
    }
}