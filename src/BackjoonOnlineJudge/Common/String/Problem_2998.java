package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2998 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        while(sb.length() % 3 != 0)
            sb.insert(0, '0');
        while(sb.length() != 0){
            String tmp = sb.substring(sb.length()-3, sb.length());
            sb.delete(sb.length()-3, sb.length());

            if(tmp.equals("000")) result.insert(0, '0');
            else if(tmp.equals("001")) result.insert(0, '1');
            else if(tmp.equals("010")) result.insert(0, '2');
            else if(tmp.equals("011")) result.insert(0, '3');
            else if(tmp.equals("100")) result.insert(0, '4');
            else if(tmp.equals("101")) result.insert(0, '5');
            else if(tmp.equals("110")) result.insert(0, '6');
            else result.insert(0, '7');
        }
        System.out.println(result);
    }
}