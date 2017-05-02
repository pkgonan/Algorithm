package BackjoonOnlineJudge.Contest.ACM_ICPC._2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10448 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int k=1; k<=T; k++){
            int K = Integer.parseInt(br.readLine());
            if(isOk(K)) System.out.println(1);
            else System.out.println(0);
        }
    }
    static boolean isOk(int K){
        for(int i=1; i<=46; i++) {
            for (int j = 1; j <= 46; j++) {
                for(int k=1; k<=46; k++){
                    int i_cnt = getCnt(i);
                    int j_cnt = getCnt(j);
                    int k_cnt = getCnt(k);

                    int sum = i_cnt + j_cnt + k_cnt;
                    if(sum/3 <= 3000 && sum == K){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int getCnt(int n){
        return n*(n+1)/2;
    }
}