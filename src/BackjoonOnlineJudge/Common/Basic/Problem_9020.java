package BackjoonOnlineJudge.Common.Basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_9020 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        ArrayList<Integer> prime = getPrime();

        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            ArrayList<Integer> result = getGoldBahe(prime, n);

            System.out.println(result.get(0) + " " + result.get(1));
        }
    }

    static ArrayList<Integer> getGoldBahe(ArrayList<Integer> prime, int n){
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<prime.size(); i++) {
            if(prime.get(i) > n) break;

            for (int j = i; j < prime.size(); j++) {
                int a = prime.get(i);
                int b = prime.get(j);

                if(a + b > n) break;

                if (a + b == n) {
                    if (!result.isEmpty()) {
                        int c = result.get(0);
                        int d = result.get(1);

                        if (Math.abs(b - a) < Math.abs(d - c)) {
                            result.clear();
                            result.add(a);
                            result.add(b);
                        }
                    } else {
                        result.add(a);
                        result.add(b);
                    }
                }
            }
        }

        return result;
    }

    static ArrayList<Integer> getPrime(){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] check = new boolean[10001];

        for(int i=2; i<=Math.sqrt(10000); i++)
            for(int j=i+i; j<=10000; j=j+i)
                check[j] = true;

        for(int i=2; i<=10000; i++)
            if(!check[i])
                result.add(i);

        return result;
    }
}