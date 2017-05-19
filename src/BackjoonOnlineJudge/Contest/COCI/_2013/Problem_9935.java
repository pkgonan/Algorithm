package BackjoonOnlineJudge.Contest.COCI._2013;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Problem_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String target = br.readLine();
        char[] result = new char[text.length()+1];

        int idx = 0;
        for(int i=0; i<text.length(); i++){
            result[idx] = text.charAt(i);
            if(isSame(result, idx, target)) idx -= target.length();
            idx++;
        }
        String res = String.valueOf(result,0, idx);
        if(res.length() != 0) System.out.println(res);
        else System.out.println("FRULA");
    }

    static boolean isSame(char[] s, int pos, String target){
        if(pos < target.length()-1) return false;
        for(int i=target.length()-1; i>=0; i--)
            if(s[pos--] != target.charAt(i)) return false;
        return true;
    }
}