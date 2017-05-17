package BackjoonOnlineJudge.Common.Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem_2750 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int N = sc.nextInt();

        while (N-- > 0)
            arr.add(sc.nextInt());
        Collections.sort(arr);

        for(int now : arr)
            System.out.println(now);
    }
}