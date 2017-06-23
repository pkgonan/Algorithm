package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Boolean> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            card.put(Integer.parseInt(st.nextToken()), true);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            if (card.containsKey(Integer.parseInt(st.nextToken())))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }
}