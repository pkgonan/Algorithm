package BackjoonOnlineJudge.Contest.ACM_ICPC._2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_11502 {
    static ArrayList<Integer> sosuList;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int k=1; k<=T; k++){
            int K = Integer.parseInt(br.readLine());
            printResult(K);
        }
    }

    static void printResult(int K){
        for(int now1 : sosuList)
            for(int now2 : sosuList)
                for(int now3 : sosuList)
                    if(now1 + now2 + now3 == K){
                        System.out.println(now1 + " " + now2 + " " + now3);
                        return;
                    }
    }

    static void init(){
        sosuList = new ArrayList<>();
        check = new boolean[1000];

        //Eratosthenes
        for(int i=2; i<Math.sqrt(1000.0); i++)
            for (int j = i+i; j < 1000; j += i)
                check[j] = true;

        for(int i=2; i<1000; i++)
            if(!check[i])
                sosuList.add(i);
    }
}