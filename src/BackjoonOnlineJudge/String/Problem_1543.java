package BackjoonOnlineJudge.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1543 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();

        int count = 0, idx = 0;
        while((idx = s.indexOf(target, idx)) != -1){
            idx += target.length();
            count++;
        }
        System.out.println(count);
    }
}