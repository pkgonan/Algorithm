package BackjoonOnlineJudge.Common.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_14561 {
    static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        char c = 'A';
        for(int k=10; k<=16; k++)
            map.put(k, String.valueOf(c++));

        for(int k=1; k<=T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            String s = getTranslate(A, N);

            if(isPalindrome(s)) System.out.println(1);
            else System.out.println(0);
        }
    }

    static String getTranslate(long num, int n){
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            int nameji = Math.toIntExact(num % n);
            if(map.containsKey(nameji)) sb.append(map.get(nameji));
            else sb.append(nameji);
            num /= n;
        }
        return sb.toString();
    }

    static boolean isPalindrome(String s){
        for(int i=0; i<s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    }
}