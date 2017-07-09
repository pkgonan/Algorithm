package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for(int i=0; i<C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            double sum = 0;
            ArrayList<Integer> arr = new ArrayList<>();

            while (st.hasMoreTokens()){
                arr.add(Integer.parseInt(st.nextToken()));
                sum += arr.get(arr.size()-1);
            }

            double avg = sum / N;
            double cnt = 0;

            for(int now : arr)
                if(now > avg)
                    cnt++;

            double result = cnt*100/N;
            System.out.printf("%.3f%%\n", result);
        }
    }
}