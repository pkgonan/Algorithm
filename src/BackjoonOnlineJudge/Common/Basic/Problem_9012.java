package BackjoonOnlineJudge.Common.Basic;

import java.util.Scanner;
import java.util.Stack;

public class Problem_9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++)
            System.out.println(getResult(sc.next()));
    }

    static String getResult(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch=='(') stack.push(ch);
            else {
                if (stack.isEmpty()) return "NO";
                if(stack.pop() != '(') return "NO";
            }
        }

        if(!stack.isEmpty()) return "NO";
        return "YES";
    }
}