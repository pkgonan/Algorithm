package BackjoonOnlineJudge.Common.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Problem_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        LinkedList<Character> link = new LinkedList<>();

        for(int i=0; i<s.length(); i++)
            link.add(s.charAt(i));

        ListIterator iterator = link.listIterator(link.size());

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            s = br.readLine();

            if(s.charAt(0) == 'L'){
                if(iterator.hasPrevious())
                    iterator.previous();
            }
            else if(s.charAt(0) == 'D'){
                if(iterator.hasNext())
                    iterator.next();
            }
            else if(s.charAt(0) == 'B'){
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            }
            else{
                iterator.add(s.charAt(2));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : link)
            sb.append(c);
        System.out.println(sb);
    }
}